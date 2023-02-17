package com.example.semka;

import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;

@Component
public class CrudMemoCardImp implements CrudMemoCard {

    File der = new File("cards");

    @Override
    public boolean saveMemoCardInFile(MemoCard memoCard) {
        File file = new File("cards/" + memoCard.getNameCard() + ".txt");
        if(!der.exists())
            der.mkdir();
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(!memoCard.getNameCard().isEmpty()) {
            try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file,false))) {
                stream.writeObject(memoCard);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }

    @Override
    public boolean editMemoCard(MemoCard editMemocard, String name, String frontSide, String backSide, String tag) {
        if(!editMemocard.getNameCard().equals(name)){
            deleteMemoCardFile(new File("cards/" + editMemocard.getNameCard() + ".txt"));
        }
        editMemocard.setNameCard(name);
        editMemocard.setTextFromFrontSideCard(frontSide);
        editMemocard.setTextFromBackSideCard(backSide);
        editMemocard.setTagCard(tag);
        saveMemoCardInFile(editMemocard);
        return true;
    }

    @Override
    public boolean deleteMemoCardFile(File file) {
        file.delete();
        return false;
    }

    @Override
    public ArrayList<MemoCard> getArrayListAllMemoCard() {
        ArrayList<MemoCard> allMemoCardArrayList = new ArrayList<>();
        File dir = new File("cards");
        if(dir.exists()){
            File[] files = dir.listFiles();
            for(int i = 0; i < files.length; i++){
                try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(files[i]))){
                    MemoCard memoCard = (MemoCard) stream.readObject();
                    allMemoCardArrayList.add(memoCard);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return allMemoCardArrayList;
    }

    @Override
    public ArrayList<MemoCard> getArrayListMemoCardForTag(String tag) {
        return null;
    }
}
