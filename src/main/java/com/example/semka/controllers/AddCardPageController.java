package com.example.semka.controllers;

import com.example.semka.CrudMemoCardImp;
import com.example.semka.MemoCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/add_card")
public class AddCardPageController {

    @Autowired
    CrudMemoCardImp crudMemoCard = new CrudMemoCardImp();

    @GetMapping
    public String getAddCardPage(Model model){
        model.addAttribute("list", getArrayListTegForPage());
        return "add_card";
    }

    public ArrayList<String> getArrayListTegForPage(){
        ArrayList <String> groupTeg = new ArrayList<>(){{
            add("Программирование");
            add("Психология");
            add("Английский");
        }};
        return groupTeg;
    }

    @PostMapping
    public String saveCardInFileAndRedirectAllCardsPage(
            @RequestParam String tag,
            @RequestParam String nameCard,
            @RequestParam String question,
            @RequestParam String answer,
            Model model
    ){
        MemoCard newCard = new MemoCard(tag,nameCard,question,answer);
        crudMemoCard.saveMemoCardInFile(newCard);
        return "redirect:/all_cards";
    }
}
