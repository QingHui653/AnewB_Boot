package com.newb.mybatis.db.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newb.mybatis.db.dao.UserDao;
import com.newb.mybatis.db.entity.User;

@Service
public class UserService{
	
	@Autowired
	private UserDao userDao;
	
	public User getUserById(int id) {
		User user = userDao.testSelectByKey(id);
		return user;
	}
	
	@Transactional
	public Boolean testWithTr(Integer id) {
		User user =new User(3, "3", "3");
		Boolean successful = userDao.save(user);
		int age =100/0;
		return successful;
	}
	
	public Boolean testNoTr(Integer id) {
		User user =new User(3, "3", "3");
		Boolean successful = userDao.save(user);
		int age =100/0;
		return successful;
	}
}
