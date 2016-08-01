package com.phonebook.controller;

import com.phonebook.controller.validators.UserValidator;
import com.phonebook.model.User;
import com.phonebook.service.Iml.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class SecurityController {
    private static final Logger LOG = Logger.getLogger(SecurityController.class);
    //TODO add loger

    private UserServiceImpl userService;
    private UserValidator validator;
    private SecurityService securityService;

    @Autowired
    public void setValidator(UserValidator validator) {
        this.validator = validator;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    String login(Model model, String error, final RedirectAttributes redirectAttributes, Principal principal){
        if(!securityService.isAuthenticated()){
             if (error != null){
                model.addAttribute("error",true);
            }
            return "security/login";
        } else {
            return "redirect:/contact";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    String registration (Model model, final RedirectAttributes redirectAttributes){
        if(!securityService.isAuthenticated()) {
            model.addAttribute("userForm", new User());
            return "security/registration";
        }else {
            return "redirect:/contact";
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm")User user, BindingResult result, Model model,
                               final RedirectAttributes redirectAttributes) {
        validator.validate(user, result);
        if (result.hasErrors()){
            return "security/registration";
        }
        userService.persist(user);
        securityService.autologin(user.getUserName(),user.getPassword());
        return "redirect:/contact";
    }
}
