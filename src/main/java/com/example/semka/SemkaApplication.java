package com.example.semka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SemkaApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SemkaApplication.class, args);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
