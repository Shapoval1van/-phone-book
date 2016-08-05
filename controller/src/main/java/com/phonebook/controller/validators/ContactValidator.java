package com.phonebook.controller.validators;

import com.phonebook.model.Contact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContactValidator implements Validator{
    public boolean supports(Class<?> aClass) {
        return Contact.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Contact contact = (Contact) o;
    }
}
