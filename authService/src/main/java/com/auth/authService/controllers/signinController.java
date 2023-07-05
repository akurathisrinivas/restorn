package com.auth.authService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import com.auth.authService.Services.UserDetailsService;
import com.auth.authService.models.User;
import com.auth.authService.request.signinRequest;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth")
public class signinController {
	
	@Autowired
   // private AuthenticationManager authenticationManager;
	private UserDetailsService useraDetailsService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody signinRequest signinrequest){
		
		//Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
			//	signinrequest.getEmail(), signinrequest.getPassword()));

        //SecurityContextHolder.getContext().setAuthentication(authentication);
		User res= useraDetailsService.loadUserByUsername(signinrequest.getEmail());
		
        //return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK,
        		// "result",res);
		//need to save data
		return ResponseEntity.ok(res);
	
	}

}
