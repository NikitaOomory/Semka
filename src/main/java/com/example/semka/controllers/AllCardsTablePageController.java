package com.example.semka.controllers;

import com.example.semka.CrudMemoCardImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/all_cards")
public class AllCardsTablePageController {

    @Autowired
    CrudMemoCardImp crudMemoCard = new CrudMemoCardImp();

    @GetMapping
    public String getAllCardsTablePage(Model model){
        model.addAttribute("cards", crudMemoCard.getArrayListAllMemoCard());
        return "all_cards";
    }
}
