package com.example.semka;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaveAndGetMemoCardForFileTest {

    MemoCard memoCard;
    SaveAndGetMemoCardForFile saver;
    File file;

    @BeforeEach
    void beforeEach() throws IOException {
        memoCard = new MemoCard("Test","TestQuestion","TestAnswer", "TestDate");
        saver = new SaveAndGetMemoCardForFile();
        file = new File("TestFile.txt");
        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Test
    void saveObjectInFile() throws IOException {
        assertEquals(true, saver.saveObjectInFile(memoCard,file));
    }

    @Test
    void getObjectFromFile() throws IOException, ClassNotFoundException {
        boolean res = false;

        if(saver.getObjectFromFile(file).equals(memoCard))
            res = true;
        assertEquals(true,res);
    }
}