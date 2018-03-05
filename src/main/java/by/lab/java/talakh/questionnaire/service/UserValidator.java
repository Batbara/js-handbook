package by.lab.java.talakh.questionnaire.service;

import by.lab.java.talakh.questionnaire.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Value should not be empty");
        if (user.getUserName().length() > 65) {
            errors.rejectValue("userName", "Username length is not appropriate");
        }
        if (isAlreadyRegistered(user)) {
            errors.rejectValue("userName", "User is already registered");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Value should not be empty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Password length is not appropriate");
        }


    }
    private boolean isAlreadyRegistered (User user){
        return userService.findUser(user.getUserName()) != null;
    }

}
