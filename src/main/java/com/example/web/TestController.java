package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
@RequestMapping("test")
public class TestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("list")
	public Object list() {
		User u=  userService.getUserById(1);
		return u;
	}
}
