package com.spring.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class password {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "333";
		String encodedPassword = encoder.encode(rawPassword);
		System.out.println(encodedPassword);

	}

}
