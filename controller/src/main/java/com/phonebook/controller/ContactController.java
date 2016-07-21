package com.phonebook.controller;

import com.phonebook.model.Contact;
import com.phonebook.service.Iml.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactServiceImpl contactService;

    @Autowired
    public void setContactService(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @RequestMapping(method = RequestMethod.GET)
    String getIndex(Model model){
        HashSet<Contact> contacts= (HashSet<Contact>)contactService.findAll();
        model.addAttribute("contacts",contacts);
        return "/contacts.jsp";
    }

}
