package com.emep.dubbo.demo.dao.impl;

import com.emep.dubbo.demo.dao.UserDao;
import com.emep.dubbo.demo.model.User;

public class UserDaoImpl implements UserDao{

	public String getUsers() {
		return "2";
	}

	public User getUser(Long id) {
		return new User(id, "Tomcat"+id+"");
	}

	
	
}
