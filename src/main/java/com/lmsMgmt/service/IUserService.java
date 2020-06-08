package com.lmsMgmt.service;



import com.lmsMgmt.models.User;

public interface IUserService {
	
	public default org.springframework.security.core.userdetails.User findUserByName(String userName) {
		return null;
	}

}
