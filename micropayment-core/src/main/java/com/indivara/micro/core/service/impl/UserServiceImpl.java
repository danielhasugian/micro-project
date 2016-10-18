package com.indivara.micro.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.indivara.micro.core.repository.UserRepository;
import com.indivara.micro.core.service.UserService;
import com.indivara.micro.model.User;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public List<User> findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
}
