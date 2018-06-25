package com.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.app.model.Users;


public interface UserService extends UserDetailsService{
	
	 Users findByEmail(String email);

	 Users save(Users registration);

}
