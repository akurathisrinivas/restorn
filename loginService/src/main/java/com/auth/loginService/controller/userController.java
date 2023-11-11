package com.auth.loginService.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.access.prepost.PreAuthorize; 
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken; 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.web.bind.annotation.*;

import com.auth.loginService.entity.AuthRequest;
import com.auth.loginService.entity.UserInfo;
import com.auth.loginService.response.signinResponse;
import com.auth.loginService.service.JwtService;
import com.auth.loginService.service.UserInfoService; 
  
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth") 
public class userController { 
  
    @Autowired
    private UserInfoService service; 
  
    @Autowired
    private JwtService jwtService; 
  
    @Autowired
    private AuthenticationManager authenticationManager; 
  
    @GetMapping("/welcome") 
    public String welcome() { 
        return "Welcome this endpoint is not secure"; 
    } 
  
    @PostMapping("/addNewUser") 
    public String addNewUser(@RequestBody UserInfo userInfo) { 
        return service.addUser(userInfo); 
    } 
  
    @GetMapping("/user/userProfile") 
    @PreAuthorize("hasAuthority('ROLE_USER')") 
    public String userProfile() { 
        return "Welcome to User Profile"; 
    } 
  
    @GetMapping("/admin/adminProfile") 
    @PreAuthorize("hasAuthority('ROLE_ADMIN')") 
    public String adminProfile() { 
        return "Welcome to Admin Profile"; 
    } 
  
    @PostMapping("/generateToken") 
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        if (authentication.isAuthenticated()) { 
            return jwtService.generateToken(authRequest.getUsername()); 
        } else { 
            throw new UsernameNotFoundException("invalid user request !"); 
        } 
    } 
    
    @PostMapping("/signin")
    public signinResponse signinauthenticateAndGetToken(@RequestBody AuthRequest authRequest) { 
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
        
        
        
        if (authentication.isAuthenticated()) { 
            
            String JWTtoken=jwtService.generateToken(authRequest.getUsername());
            
            String msg="User Login successfully";
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            //System.out.println(authenticationManager.getClass());
            //authenticationManager.getClass().
            
            //System.out.println(authentication.getPrincipal());
            //System.out.println(userDetails.getPassword());

            List<UserInfo> user=this.service.checkGetUserDetails(authRequest.getUsername(), userDetails.getPassword());
            
            return new signinResponse(
            		user.get(0).getId(),
            		user.get(0).getName(),
            		user.get(0).getEmail(),
            		user.get(0).getRoles(),
            		msg,
            		JWTtoken);
        } else { 
            throw new UsernameNotFoundException("invalid user request !"); 
        } 
    } 
    
  
} 
