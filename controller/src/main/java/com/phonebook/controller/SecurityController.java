package com.phonebook.controller;

import com.phonebook.controller.validators.UserValidator;
import com.phonebook.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SecurityController {
    private static final Logger LOG = Logger.getLogger(SecurityController.class);
    //TODO add loger


    private UserValidator validator;

    @Autowired
    public void setValidator(UserValidator validator) {
        this.validator = validator;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login(Model model, String error){
         if (error != null){
            model.addAttribute("error",true);
        }
        return "security/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    ModelAndView registration (Model model){
        return  new ModelAndView("security/registration","userForm", new User());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")User user, BindingResult result, Model model,
                               final RedirectAttributes redirectAttributes) {
        validator.validate(user, result);
        return "security/registration";
    }
}
