package com.restorn.SignupService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restorn.SignupService.repository.UserRepository;

@Service
public class signupService {
	
	@Autowired
	UserRepository userRespository;
	
	

}
