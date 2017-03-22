package com.newb.mybatis.db.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.newb.mybatis.db.dao.UserMapper;
import com.newb.mybatis.db.entity.User;
import com.newb.mybatis.db.service.common.BaseServiceImpl;

@Service
public class UserService extends BaseServiceImpl<User>{
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserById(int id) {
		User user = userMapper.testSelectByKey(id);
		return user;
	}
	
	@SuppressWarnings("unused")
	@Transactional
	public Boolean testWithTr(Integer id) {
		User user =new User(3, "3", "3");
		Boolean successful = userMapper.save(user);
		int age =100/0;
		return successful;
	}
	
	@SuppressWarnings("unused")
	public Boolean testNoTr(Integer id) {
		User user =new User(3, "3", "3");
		Boolean successful = userMapper.save(user);
		int age =100/0;
		return successful;
	}
	
	public List<User> testPage(Integer pageNo,Integer pageNum) {
		PageHelper.startPage(pageNo, pageNum);
//		PageHelper.startPage(10, 20);
		List<User> userList = userMapper.selectAll();
		return userList;
	}
}
