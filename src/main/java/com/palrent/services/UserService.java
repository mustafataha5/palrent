package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.palrent.models.User;
import com.palrent.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository ; 
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User u) {
		return userRepository.save(u);
	}
	
	public User findUser(Long id) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null ;
	}
	
	public User updateUser(User user) {
		Optional<User> optional = userRepository.findById(user.getId());
		if(optional.isPresent()) {
			return userRepository.save(user);
		}
		return null ;
	}
	
	public User prepareUser(User u,BindingResult result){
		
		Optional<User> optional = userRepository.findByEmail(u.getEmail());
		
		if(optional.isPresent()) {
			result.rejectValue("email", "MATCH","Email already used");
			return null;
		}
		
		if(!u.getPassword().equals(u.getConfirm())) {
			result.rejectValue("confirm", "MATCH","Confirm password does not match ");
			return null;
		}
		
		
		String hashPass = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashPass);
		return u ; 
	}
	
	
	
	

}
