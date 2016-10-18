package com.indivara.micro.core.service;

import java.util.List;

import com.indivara.micro.model.User;

public interface UserService {
	
	public List<User> findAll();
	public List<User> findByUserName(String userName);
}
