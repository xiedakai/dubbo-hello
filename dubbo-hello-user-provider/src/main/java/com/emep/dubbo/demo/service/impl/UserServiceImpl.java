package com.emep.dubbo.demo.service.impl;

import com.emep.dubbo.demo.dao.UserDao;
import com.emep.dubbo.demo.model.User;
import com.emep.dubbo.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User getUser(Long id) {
		return userDao.getUser(id);
	}

	public String getUsers() {
		
		return userDao.getUsers();
	}
}