package com.example.demo.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class practice {

    @GetMapping("/html/pratice")
    public String practice() {
        System.out.println("html 연습");

        return "html/pratice";
    }
}
