package com.example.myapp.services;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.User;
import com.example.myapp.repositories.UserRepository;




@RestController
public class UserService {
    @Autowired
    UserRepository userRepository;
    

    @GetMapping("/api/user")    
    public Iterable<User> findAllUsers(){
        return userRepository.findAll();
    }
    
    @PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}

    
  

}



