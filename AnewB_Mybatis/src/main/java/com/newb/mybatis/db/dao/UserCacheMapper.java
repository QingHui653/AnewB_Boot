package com.newb.mybatis.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.newb.mybatis.db.entity.UserCache;
import com.newb.mybatis.db.service.common.MyMapper;

@Mapper
public interface UserCacheMapper extends MyMapper<UserCache> {
}