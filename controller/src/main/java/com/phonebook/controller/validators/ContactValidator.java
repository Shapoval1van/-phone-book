package com.phonebook.controller.validators;

import com.phonebook.model.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ContactValidator implements Validator{
    public boolean supports(Class<?> aClass) {
        return Contact.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Contact contact = (Contact) o;
        Pattern pattern = Pattern.compile("^((8|\\+3)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(contact.getMobilPhone());
        if(!matcher.find()){
            errors.rejectValue("mobilPhone", "validator.phone");
        }
    }
}
