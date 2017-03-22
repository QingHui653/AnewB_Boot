package com.newb.mybatis.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.newb.mybatis.db.entity.Result;
import com.newb.mybatis.db.service.common.MyMapper;

@Mapper
public interface ResultMapper extends MyMapper<Result> {
}