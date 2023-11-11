package com.auth.loginService.service;

 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import com.auth.loginService.entity.UserInfo;
import com.auth.loginService.repository.UserInfoRepository;

import java.util.List;
import java.util.Optional; 
  
@Service
public class UserInfoService implements UserDetailsService { 
  
    @Autowired
    private UserInfoRepository repository; 
  
    @Autowired
    private PasswordEncoder encoder; 
  
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
  
        Optional<UserInfo> userDetail = repository.findByName(username); 
  
        // Converting userDetail to UserDetails 
        return userDetail.map(UserInfoDetails::new) 
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
    } 
  
    public String addUser(UserInfo userInfo) { 
        userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
        System.out.println(userInfo.getPassword());
        repository.save(userInfo); 
        
        return "User Added Successfully"; 
    } 
    
    public List<UserInfo> checkGetUserDetails(String username,String password){
       
    	//String encode_pwd=encoder.encode(password);
    	
    	
    	//System.out.println(encode_pwd);
    	
    	List<UserInfo> user=this.repository.findUserDetails(username,password);
    	
    	return user;
    }
} 
