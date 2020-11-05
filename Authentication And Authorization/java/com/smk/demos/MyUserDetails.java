package com.smk.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smk.demos.entity.User;
import com.smk.demos.repository.UserRepository;

@Service
public class MyUserDetails implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user=repo.findByUsername(username);
		if(user==null)
		{
			throw new UsernameNotFoundException("404");
		}

		return new UserPrincipal(user);
	}

}
