package com.example.myapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.myapp.repositories.UserRepository;



public class UserService {

	@Autowired
    UserRepository userRepository;
}
