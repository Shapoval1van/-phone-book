package com.phonebook.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainPageController {
    private static final Logger LOG = Logger.getLogger(MainPageController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model){
        return "index";
    }
}
