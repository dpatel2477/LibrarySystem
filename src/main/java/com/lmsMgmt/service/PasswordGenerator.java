package com.lmsMgmt.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encodePassword = encoder.encode("demo");
			System.out.println(encodePassword);
	}

}
