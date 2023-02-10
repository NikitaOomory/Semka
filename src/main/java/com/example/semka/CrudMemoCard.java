package com.example.semka;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public interface CrudMemoCard {
    boolean saveMemoCardInFile(MemoCard memoCard);
    boolean editMemoCard(MemoCard editMemocard, String name, String front, String back, String tag);
    boolean deleteMemoCardFile(File file);
    ArrayList<MemoCard> getArrayListAllMemoCard();
    ArrayList<MemoCard> getArrayListMemoCardForTag(String tag);
}
