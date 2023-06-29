package com.auth.authService.Services;

import org.springframework.stereotype.Service;

import com.auth.authService.Repository.UserRepository;
import com.auth.authService.models.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsService {
	
	private UserRepository userRepository;
	
    public UserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    public User loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
          User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                 .orElseThrow(() ->
                         new UsernameNotFoundException("User not found with username or email: "+ usernameOrEmail));

			/*
			 * Set<GrantedAuthority> authorities = user .getRoles() .stream() .map((role) ->
			 * new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
			 * return new
			 * org.springframework.security.core.userdetails.User(user.getEmail(),
			 * user.getPassword(), authorities);
			 */
           //Set<authorities> name= new user.getRoles() .stream() .map((role) ->
			  //new Role(role.getName())).collect(Collectors.toSet());
          
        User user_result=new User(
        		user.getId(),
        		user.getUsername(),
        		user.getEmail(),
        		user.getPassword(),
        		user.getRoles()
        		);

        return user_result;
        
    }

}
