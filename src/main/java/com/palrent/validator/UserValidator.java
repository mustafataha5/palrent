package com.palrent.validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.palrent.models.User;
import com.palrent.repositories.UserRepository;



@Component
public class UserValidator implements Validator {
    
	@Autowired
	UserRepository userRepository ; 
    //    1
    @Override
    public boolean supports(Class<?> c) {
        return User.class.equals(c);
    }
    
    // 2
    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        
        if (!user.getConfirm().equals(user.getPassword())) {
            // 3
            errors.rejectValue("confirm", "Match");
        }
        User check = userRepository.findByUsername(user.getUsername());
        if(check !=null) {
        	errors.rejectValue("username", "Exist");
        } 
        Date now = new  Date();
        if(user.getDateOfBirth().after(now)) {
        	errors.rejectValue("dateOfBirth", "Future");
        }
//        Date past = new Date("1920-1-1");
//        if(user.getDateOfBirth().before(past)) {
//        	errors.rejectValue("dateOfBirth", "Past");
//        }
        
    }
}
