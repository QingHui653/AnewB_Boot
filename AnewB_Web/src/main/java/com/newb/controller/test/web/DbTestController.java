package com.newb.controller.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newb.mybatis.db.entity.Movie;
import com.newb.mybatis.db.entity.User;
import com.newb.mybatis.db.service.MovieService;
import com.newb.mybatis.db.service.UserService;

import tk.mybatis.mapper.entity.Example;

@RestController
@RequestMapping("/db")
public class DbTestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * 添加事务
	 * @param id
	 * @return
	 */
	@GetMapping("/dbexcWithTr/{id}")
	public Object dbExcWithTr(@PathVariable("id") Integer id ) {
		Boolean success =  userService.testWithTr(id);
		return success;
	}
	
	/**
	 * 没有添加事务
	 * @param id
	 * @return
	 */
	@GetMapping("/dbexcNoTr/{id}")
	public Object dbExcNoTr(@PathVariable("id") Integer id ) {
		Boolean success =  userService.testNoTr(id);
		return success;
	}
	
	/**
	 * 测试通用mapper
	 * @param id
	 * @return
	 */
	@GetMapping("/myMapperUser")
	public Object myMapperUser() {
		Example e= new Example(User.class);
		e.createCriteria().andBetween("oid", "1", "4");
		List<User> userList = userService.selectByExample(e);
		return userList;
	}
	
	/**
	 * 测试通用mapper
	 * @param id
	 * @return
	 */
	@GetMapping("/myMapperMovie")
	public Object myMappeMovier() {
		Movie m = movieService.selectByKey(1);
		return m;
	}
	
	/**
	 * 测试通用mapper
	 * @param id
	 * @return
	 */
	@GetMapping("/myMapperPage/{pageNum}/{pageNo}")
	public Object myMappePage(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageNo") Integer pageNo) {
		List<User> userList = userService.testPage(pageNo, pageNum);
		return userList;
	}
}
