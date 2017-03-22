package com.newb.mybatis.db.service.common;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

public class MyMapperImpl<T> extends MapperTemplate{

	public MyMapperImpl(Class<?> mapperClass, MapperHelper mapperHelper) {
		super(mapperClass, mapperHelper);
	}
	
	
	public String CommonSelMapper(MappedStatement ms) {
//		Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
//        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
//        sql.append(SqlHelper.selectAllColumns(entityClass));
//        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
//        sql.append(SqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
        sql.append("${_parameter}");
		return sql.toString();
	}
	
	public String CommonDelMapper(MappedStatement ms) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from result where oid=#{key}");
		return sql.toString();
	}
	
}
