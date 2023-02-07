package com.example.semka.controllers;

import com.example.semka.MemoCard;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/add_card")
public class AddCardPageController {

    File der = new File("cards");

    @GetMapping
    public String getAddCardPage(Model model){
        List groupTeg = new ArrayList<>(){{
           add("Программирование");
           add("Психология");
           add("Английский");
        }};
        model.addAttribute("list", groupTeg);
        return "add_card";
    }

    @PostMapping
    public String saveCardInFile(
            @RequestParam String teg,
            @RequestParam String nameCard,
            @RequestParam String question,
            @RequestParam String answer,
            Model model
    ){
        MemoCard newCard = new MemoCard(teg,nameCard,question,answer,"date");
        File file = new File("cards/" + nameCard + ".txt");

        if(!der.exists())
            der.mkdir();
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(!nameCard.isEmpty()){
            try(ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))){
                stream.writeObject(newCard);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return "redirect:/all_cards";
    }
}
