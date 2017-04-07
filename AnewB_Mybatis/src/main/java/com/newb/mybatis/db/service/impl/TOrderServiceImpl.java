package com.newb.mybatis.db.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newb.mybatis.db.dao.TOrderMapper;
import com.newb.mybatis.db.entity.TOrder;
import com.newb.mybatis.db.service.TOrderServiceI;
import com.newb.mybatis.db.service.common.BaseServiceImpl;

@Service("TOrderService")
public class TOrderServiceImpl extends BaseServiceImpl<TOrder> implements TOrderServiceI{
	
	@Autowired
	private TOrderMapper mapper;
	
	public int insertByMapper(TOrder model) {
		return mapper.insertByMapper(model);
	}
	
	public int insertByXML(TOrder model) {
		return mapper.insertByXML(model);
	}
	
	public int insertByComm(TOrder model) {
		return mapper.insert(model);
	}
}
