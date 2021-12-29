package com.mediscreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MediscreenController {

    @RequestMapping("/")
    public String home(Model model) {

        return "home";
    }
}
