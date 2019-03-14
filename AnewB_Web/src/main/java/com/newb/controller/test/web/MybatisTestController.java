package com.newb.controller.test.web;

import java.util.List;

import com.newb.common.util.SpringUtil;
import com.newb.mybatis.config.test.pro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.newb.mybatis.db.entity.Movie;
import com.newb.mybatis.db.entity.TOrder;
import com.newb.mybatis.db.entity.User;
import com.newb.mybatis.db.service.MovieService;
import com.newb.mybatis.db.service.TOrderServiceI;
import com.newb.mybatis.db.service.UserService;

import tk.mybatis.mapper.entity.Example;

import javax.sql.DataSource;

@RestController
@RequestMapping("/db")
public class MybatisTestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TOrderServiceI tOrderService;

	@Autowired
	private pro pro;

	/**
	 * 测试从配置文件读取参数
	 * @return
	 */
	@GetMapping("/helloYml")
	@ResponseBody
	public String helloYml(){
		System.out.println("--读取yml "+pro.getUrl());
		System.out.println("--读取yml "+pro.getValidationQuery());
		return pro.getUsername();
	}

	/**
	 * 测试spring boot 运行 返回json
	 * @return
	 */
	@GetMapping("springUtil")
	@ResponseBody
	public Object springUtil() {
		DataSource dataSource= (DataSource) SpringUtil.getBean("primaryDataSource");
		System.out.println(dataSource.toString());
		return dataSource.toString();
	}

	/**
	 * 测试spring boot 运行 返回json
	 * @return
	 */
	@GetMapping("key1")
	@ResponseBody
	public Object key() {
		return userService.selectByKey(1);
	}

	/**
	 * 没有添加事务
	 * @param id
	 * @return
	 */
	@GetMapping("/test")
	public Object test() {
		Example e= new Example(Movie.class);
		List<Movie> movieList =  movieService.selectByExample(e);
		return movieList;
	}
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
	
	@GetMapping(value="/sharding")
	@ResponseBody
	public Object shardingTest() {
		/**
		 * 分页插件不支持主键自增,SELECT LAST_INSERT_ID();配置在model中
		 */
		TOrder tO0=new TOrder(0, 2, "第0条数据");
		int bool0= tOrderService.insertByMapper(tO0);
		TOrder tO1=new TOrder(1, 3, "第1条数据");
		int bool1= tOrderService.insertByMapper(tO1);
		TOrder tO2=new TOrder(2, 4, "第2条数据");
		int bool2= tOrderService.insertByComm(tO2);
		
		return bool0;
	}
}
