package com.newb.mybatis.db.service.common;

import java.util.List;

/**
 * 通用接口
 */
public interface IService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
    
    List<T> CommonSelMapper(String key);
    
    int CommonDelMapper(String key);

}
