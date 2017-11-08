package com.emep.dubbo.demo.dao;

import com.emep.dubbo.demo.model.User;

public interface UserDao {
	
	String getUsers();
	
	User getUser(Long id);

}
