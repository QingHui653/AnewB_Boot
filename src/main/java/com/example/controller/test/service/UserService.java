package com.example.controller.test.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.test.dao.UserDao;
import com.example.controller.test.entity.User;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User getUserById(int id) {
		User user = userDao.testSelectByKey(id);
		return user;
	}

}
