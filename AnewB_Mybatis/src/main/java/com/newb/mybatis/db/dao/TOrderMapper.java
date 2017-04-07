package com.newb.mybatis.db.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.newb.mybatis.db.entity.TOrder;
import com.newb.mybatis.db.service.common.MyMapper;

@Mapper
public interface TOrderMapper extends MyMapper<TOrder> {
	@Insert("insert into t_order(order_id,user_id,status) vaules(#{orderId},#{userId},#{status})")
	int insertByMapper(TOrder model);
	
	int insertByXML(TOrder model);
	
}