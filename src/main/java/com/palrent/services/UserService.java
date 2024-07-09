package com.palrent.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public User prepareUser(User u){
		String hashPass = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
		u.setPassword(hashPass);
		return u ; 
	}
	
	
	
	

}
