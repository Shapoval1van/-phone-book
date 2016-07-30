package com.phonebook.controller;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import com.phonebook.service.Iml.ContactServiceImpl;
import com.phonebook.service.Iml.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactServiceImpl contactService;
    private GroupServiceImpl groupService;

    @Autowired()
    public void setContactService(ContactServiceImpl contactService) {
        this.contactService = contactService;
    }

    @Autowired()
    public void setGroupService(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(method = RequestMethod.GET)
    public String getContactsList(Model model){
        User user = new User();
        user.setId(1);
        Set<Contact> contacts = contactService.findAllByCteator(user);
        model.addAttribute("contacts",contacts);
        model.addAttribute("groups",groupService.findByUserId(1));
        return "contacts/list";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/id{id}",  method = RequestMethod.GET)
    public String showContact(@PathVariable("id") int id, Model model){
        model.addAttribute("contact",contactService.findById(id));
        return "contacts/show";
    }
}
