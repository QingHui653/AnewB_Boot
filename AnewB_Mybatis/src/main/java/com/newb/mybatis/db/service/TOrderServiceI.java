package com.newb.mybatis.db.service;

import com.newb.mybatis.db.entity.TOrder;
import com.newb.mybatis.db.service.common.IService;

public interface TOrderServiceI extends IService<TOrder>{
	int insertByMapper(TOrder model);
	
	int insertByXML(TOrder model);
	
	int insertByComm(TOrder model);
}

