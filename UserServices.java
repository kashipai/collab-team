package com.example.springSecurity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;

import com.example.springSecurity.Model.Person;
import com.example.springSecurity.Model.Users;
import com.example.springSecurity.Repository.PersonRepo;
import com.example.springSecurity.Repository.UserRepository;

public class UserServices implements UserDetailsService {

	 @Autowired
	 private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repo.findUsersByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new UserInfo(user);
	}
	

}
