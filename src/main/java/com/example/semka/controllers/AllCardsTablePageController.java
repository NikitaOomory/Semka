package com.example.semka.controllers;

import com.example.semka.MemoCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/all_cards")
public class AllCardsTablePageController {

    @GetMapping
    public String getAllCardsTablePage(Model model) throws IOException, ClassNotFoundException {
        ArrayList<MemoCard> memoCardArrayList = new ArrayList<>();

        File dir = new File("cards");
        if(dir.exists()){
            File[] files = dir.listFiles();
            for(int i = 0; i < files.length; i++){
                try(ObjectInputStream stream = new ObjectInputStream(new FileInputStream(files[i]))){
                    MemoCard memoCard = (MemoCard) stream.readObject();
                    memoCardArrayList.add(memoCard);
                }
            }
        }
        model.addAttribute("cards",memoCardArrayList);
        return "all_cards";
    }
}
