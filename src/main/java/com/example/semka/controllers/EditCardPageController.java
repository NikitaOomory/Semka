package com.example.semka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/all_cards/editCard/{nameCard}")
@Controller
public class EditCardPageController {
    @GetMapping
    public String getEditCardPage(@PathVariable(value = "nameCard") String nameCard,Model model){
        model.addAttribute("1","2");
        return "edit_card";
    }

    @PostMapping
    public String saveEditedCardInFileAndRedirectAllCardsPage(@PathVariable(value = "nameCard") String nameCard,Model model){
        return "redirect:/all_cards";
    }


}
