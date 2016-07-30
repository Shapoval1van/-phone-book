package com.phonebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecurityController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login(Model model, String error){
        if (error != null){model.addAttribute("error",true);}
        return "security/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    String registration (Model model){
        return  "security/registration";
    }
}
