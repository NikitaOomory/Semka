package com.example.semka.controllers;

import com.example.semka.CrudMemoCardImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interview")
public class InterviewPageController {

    @Autowired
    CrudMemoCardImp crudMemoCard = new CrudMemoCardImp();

    @GetMapping
    public String getInterviewPage(Model model){
        model.addAttribute("questions", crudMemoCard.getArrayListAllMemoCard());
        return "interview";
    }

}
