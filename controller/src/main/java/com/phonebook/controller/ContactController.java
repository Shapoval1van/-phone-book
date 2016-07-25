package com.phonebook.controller;

import com.phonebook.model.Contact;
import com.phonebook.service.Iml.ContactServiceImpl;
import com.phonebook.service.Iml.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;

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

    @RequestMapping(method = RequestMethod.GET)
    String getContactsList(Model model){
        //change to treeSet
        HashSet<Contact> contacts= (HashSet<Contact>)contactService.findAll();
        model.addAttribute("contacts",contacts);
        model.addAttribute("groups",groupService.findByUserId(1));
        return "contacts/list";
    }

    @RequestMapping(value = "/id{id}",  method = RequestMethod.GET)
    String showContact(@PathVariable("id") int id, Model model){
        model.addAttribute("contact",contactService.findById(id));
        return "contacts/show";
    }
}
