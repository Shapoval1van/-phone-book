package com.phonebook.controller;

import com.phonebook.controller.validators.ContactValidator;
import com.phonebook.model.Address;
import com.phonebook.model.Contact;
import com.phonebook.model.User;
import com.phonebook.service.Iml.AddressServiceImpl;
import com.phonebook.service.Iml.ContactServiceImpl;
import com.phonebook.service.Iml.GroupServiceImpl;
import com.phonebook.service.Iml.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Date;
import java.util.Set;

@Controller
@RequestMapping("/contact")
public class ContactController {
    private static final Logger LOG = Logger.getLogger(ContactController.class);

    private ContactServiceImpl contactService;
    private GroupServiceImpl groupService;
    private SecurityService securityService;
    private UserServiceImpl userService;
    private AddressServiceImpl addressService;
    private ContactValidator contactValidator;

    @Autowired
    public void setContactValidator(ContactValidator contactValidator) {
        this.contactValidator = contactValidator;
    }

    @Autowired
    public void setAddressService(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

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
    public String getContactsList(Model model, Principal principal){
        User user = userService.findUserByUsername(principal.getName());
        Set<Contact> contacts = contactService.findAllByCteator(user);
        model.addAttribute("contacts",contacts);
        model.addAttribute("groups",groupService.findByUserId(1));
        return "contacts/list";
    }
    
    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/id{id}",  method = RequestMethod.GET)
    public String showContact(@PathVariable("id") int id, Model model, Principal principal,
                              final RedirectAttributes redirectAttributes){
        if(contactService.isExistForThisCreator(
                userService.findUserByUsername(principal.getName()).getId(), id)){
            model.addAttribute("contact",contactService.findById(id));
            return "contacts/show";
        }else {
            return "redirect:/contact";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "id{id}/edit", method = RequestMethod.GET)
    public String editContact(@PathVariable("id") int id, ModelMap map, Principal principal, final  RedirectAttributes redirectAttributes){
        int userId = userService.findUserByUsername(principal.getName()).getId();
        if(contactService.isExistForThisCreator(userId, id)){
            map.addAttribute("contact",contactService.findById(id));
            map.addAttribute("groups", groupService.findByUserId(userId));
            map.addAttribute("contactForm", new Contact());
            return "contacts/edit";
        }else {
            return "redirect:/contact";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "id{id}/edit", method = RequestMethod.POST)
    public String editContact( @ModelAttribute("contactForm")
                                   Contact contact, BindingResult result,@PathVariable("id") int id, Model model,
                               final RedirectAttributes redirectAttributes, Principal principal){
        int userId = userService.findUserByUsername(principal.getName()).getId();
        Contact oldContact = contactService.findById(id);
        contactValidator.validate(contact, result);
        if(result.hasErrors()){
            model.addAttribute("contact",oldContact);
            model.addAttribute("groups", groupService.findByUserId(userId));
            return "contacts/edit";
        }
        if(contactService.isExistForThisCreator(userId, id)){
            Address oldAddress =  oldContact.getAddress();
            Address newAddress =  new Address();
            if(oldAddress!=null){
                newAddress.setId(oldAddress.getId());
                newAddress.setCountryName(contact.getAddress().getCountryName());
                newAddress.setCityName(contact.getAddress().getCityName());
                newAddress.setStreetsName(contact.getAddress().getStreetsName());
                addressService.update(newAddress);
                contact.setAddress(newAddress);
            }
            contact.setCreator(oldContact.getCreator());
            contact.setDateCreating(new Date(System.currentTimeMillis()));
//            contact.setGroup(groupService.findById(contact.getGroup().getId()));
            if(contact.getGroup().getId()==null){
                contact.setGroup(null);
            }
            contactService.update(contact);
            model.addAttribute("contact",contact);
            model.addAttribute("groups", groupService.findByUserId(userId));
            model.addAttribute("edit_message",true);
            return "contacts/edit";
        }else {
            return "redirect:/contact";
        }

    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public  String createContact(ModelMap map, Principal principal){
        int userId = userService.findUserByUsername(principal.getName()).getId();
        map.addAttribute("contactForm", new Contact());
        map.addAttribute("groups", groupService.findByUserId(userId));
        return "contacts/create";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public  String createContact( @ModelAttribute("contactForm") Contact contact, BindingResult result,
            ModelMap map, Principal principal, final RedirectAttributes redirectAttributes){
        int userId = userService.findUserByUsername(principal.getName()).getId();
        contactValidator.validate(contact,result);
        if(result.hasErrors()){
            return  "contacts/create";
        }
        contact.setDateCreating(new Date(System.currentTimeMillis()));
        contact.setCreator(userService.findById(userId));
        Address existAddress = addressService.findByFormData(contact.getAddress().getCountryName(),
                contact.getAddress().getCityName(), contact.getAddress().getStreetsName());
        if(existAddress != null){
            contact.setAddress(existAddress);
        }
        if(contact.getGroup().getId()==null){
            contact.setGroup(null);
        }
        contactService.persist(contact);
        return "redirect:/contact";
    }

}
