package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.entity.User;

@Mapper
public interface UserDao{

	@Select("select * from user where oid=#{id}")
    User testSelectByKey(int id);

	@Select("select * from user where oid>=0 for update")
	List<User> selectAllForUpdate();
	
	@Select("select password from user where oid=#{id}")
	String selectPW(int oid);

}