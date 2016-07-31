package com.phonebook.controller.validators;

import com.phonebook.model.User;
import com.phonebook.service.Iml.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements Validator {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        User user = (User)o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userName","validator.writeSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","validator.writeSpace");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passwordConfirm","validator.writeSpace");

        if(userService.findUserByUsername(user.getUserName())!=null){
            errors.rejectValue("userName","validator.userExist");
        }
        if(!user.getPassword().equals(user.getPasswordConfirm())){
            errors.rejectValue("password","validator.passwordDontMatch");
        }
        if(user.getUserName().length()<5 || user.getUserName().length()>15){
            errors.rejectValue("userName","validator.userNameSize");
        }
        if(user.getPassword().length()<6 || user.getPassword().length()>15){
            errors.rejectValue("password","validator.passwordSize");
        }
        if(!passwordValidation(user.getPassword())){
            errors.rejectValue("password","validator.passwordType");
        }
    }

    private boolean passwordValidation(String password){
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            Pattern patternNum = Pattern.compile("[0-9]+");
            Matcher matcherNum = patternNum.matcher(password);
            if(matcherNum.find()){
                return true;
            }
        }
        return false;
    }
}
