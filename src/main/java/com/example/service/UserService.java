package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User getUserById(int id) {
		User user = userDao.testSelectByKey(id);
		return user;
	}

}
