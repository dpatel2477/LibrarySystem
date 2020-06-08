package com.lmsMgmt.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lmsMgmt.repository.UserRepository;

@Service
public class UserService implements IUserService, UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
    public User findUserByName(String userName) {
        com.lmsMgmt.models.User userFromDb = userRepository.findByUsername(userName);
        if (userFromDb == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(userName, userFromDb.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
    }
	
	@Override
	public UserDetails loadUserByUsername(String username){
		return findUserByName(username);
		
	}
	
}
