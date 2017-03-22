package com.newb.mybatis.db.dao;

import org.apache.ibatis.annotations.Mapper;

import com.newb.mybatis.db.entity.Movie;
import com.newb.mybatis.db.service.common.MyMapper;

@Mapper
public interface MovieMapper extends MyMapper<Movie> {
}