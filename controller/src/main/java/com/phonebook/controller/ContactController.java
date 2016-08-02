package com.phonebook.controller;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import com.phonebook.service.Iml.ContactServiceImpl;
import com.phonebook.service.Iml.GroupServiceImpl;
import com.phonebook.service.Iml.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Set;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private static final Logger LOG = Logger.getLogger(ContactController.class);

    private ContactServiceImpl contactService;
    private GroupServiceImpl groupService;
    private SecurityService securityService;
    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setSecurityService(SecurityService securityService) {
        this.securityService = securityService;
    }

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
    public String showContact(@PathVariable("id") int id, Model model, final RedirectAttributes){
        if(contactService.isExistForThisCreator(
                userService.findUserByUsername(securityService.findLoggedInUsername()).getId(), id)){
            model.addAttribute("contact",contactService.findById(id));
            return "contacts/show";
        }else {
            return "redirect:/contact";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "id{id}/edit")
    public String editcontact(@PathVariable("id") int id, Model model){
        return "contact/edit";
    }
}
