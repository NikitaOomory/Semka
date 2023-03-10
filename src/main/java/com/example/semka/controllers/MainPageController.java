package com.example.semka.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.*;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String getMainPage(Model model) throws IOException, ClassNotFoundException {
        model.addAttribute("text", getTextForPageFromFile());
        return "main";
    }

    public String getTextForPageFromFile() throws IOException {
        File file = new File("TextForMainPage");
        if(!file.exists()){
            file.createNewFile();
        }
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
            StringBuilder result = new StringBuilder();
            char[] buffer = new char[8192];
            int count = reader.read(buffer);
            while(count > 0){
                result.append(buffer);
                count = reader.read(buffer);
            }
            return result.toString();
        }
        catch (IOException e){
            return "Ошибка чтения из файла";
        }
    }

}
