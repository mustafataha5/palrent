package com.palrent.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.palrent.models.LoginUser;
import com.palrent.models.User;
import com.palrent.repositories.RoleRepository;
import com.palrent.repositories.UserRepository;

@Service
public class UserService {
	
	 private UserRepository userRepository;
	    private RoleRepository roleRepository;
	    private BCryptPasswordEncoder bCryptPasswordEncoder;
	    
	    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
	        this.userRepository = userRepository;
	        this.roleRepository = roleRepository;
	        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	    }
	
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
	
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	public User updateUser(Long id,User userDetails) {
		Optional<User> optional = userRepository.findById(id);
		if(optional.isPresent()) {
			
			User user = optional.get();
			user.setFirstName(userDetails.getFirstName());
            user.setLastName(userDetails.getLastName());
            user.setUsername(userDetails.getUsername());
            user.setDateOfBirth(userDetails.getDateOfBirth());
            user.setUrlImage(userDetails.getUrlImage());
            user.setConfirm("password");
            user.setPhone(userDetails.getPhone());
            user.setUpdatedAt(new Date()); // Set the updated date
            return userRepository.save(user);
		}
		return null ;
	}
	 // 1
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        userRepository.save(user);
    }
     
     // 2 
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
        userRepository.save(user);
    }    
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	
//	public User prepareUser(User u,BindingResult result){
//		
//		Optional<User> optional = userRepository.findByEmail(u.getEmail());
//		
//		if(optional.isPresent()) {
//			result.rejectValue("email", "MATCH","Email already used");
//			return null;
//		}
//		
//		if(!u.getPassword().equals(u.getConfirm())) {
//			result.rejectValue("confirm", "MATCH","Confirm password does not match ");
//			return null;
//		}
//		
//		
//		String hashPass = BCrypt.hashpw(u.getPassword(), BCrypt.gensalt());
//		u.setPassword(hashPass);
//		return u ; 
//	}
//	
//	
//	 public User register(User newUser, BindingResult result) {
//		    
//	    	// TO-DO - Reject values or register if no errors:
//	        
//	        // Reject if email is taken (present in database)
//	    	Optional<User> optional = userRepository.findByEmail(newUser.getEmail());
//	    	if(optional.isPresent()){
//	    		result.rejectValue("email", "exist", "The Email already used by other user!");
//	    	}
//	        // Reject if password doesn't match confirmation
//	        if(!newUser.getPassword().equals(newUser.getConfirm())){
//	        	 result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
//	        }
//	        // Return null if result has errors
//	        if(result.hasErrors()) {
//	            // Exit the method and go back to the controller 
//	            // to handle the response
//	            return null;
//	        }
//	        // Hash and set password, save user to database
//	        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
//	        newUser.setPassword(hashed);
//	        return userRepository.save(newUser);
//	    
//	        
//	    }
//	    // This method will be called from the controller
//	    // whenever a user submits a login form.
//	        public User login(LoginUser newLoginObject, BindingResult result) {
//	        // TO-DO - Reject values:
//	        
//	    	// Find user in the DB by email
//	        	Optional<User> optional = userRepository.findByEmail(newLoginObject.getEmail());
//	        // Reject if NOT present
//	        	//System.out.println(">>>>>>>>>>>>>>>>>>>>");
//	        	if(!optional.isPresent()) {
//	        		result.rejectValue("email", "notmatch", "Login error: The Email or password wrong!");
//	        		return null ;
//	        	}
//	        	//System.out.println(optional.get());
//	        	String passwordEntered = newLoginObject.getPassword();
//	        	User user = optional.get();
//	        // Reject if BCrypt password match fails
//	        	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
//	        	    result.rejectValue("password", "Matches", "Invalid Password!");
//	        	}
//	        // Return null if result has errors
//	        	if(result.hasErrors()) {
//	                // Exit the method and go back to the controller 
//	                // to handle the response
//	                return null;
//	            }
//	        // Otherwise, return the user object
//	        	return user;
//	    }
//	

}
