package com.phonebook.controller;

import com.phonebook.model.Group;
import com.phonebook.model.User;
import com.phonebook.service.Iml.GroupServiceImpl;
import com.phonebook.service.Iml.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class GroupController {

    GroupServiceImpl groupService;
    UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGroupService(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/create-group", method = RequestMethod.GET)
    public String createGroup (ModelMap model, Principal principal){
        model.addAttribute("groupForm", new Group());
        return "group/createG";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/create-group", method = RequestMethod.POST)
    public String createGroup (@ModelAttribute("groupForm") Group group,
                               ModelMap map, Principal principal,
                               final RedirectAttributes redirectAttributes){
        User user = userService.findUserByUsername(principal.getName());
        group.setCreator(user);
        group.setDefault(false);
        groupService.persist(group);
        return "redirect:/contact";
    }
}
