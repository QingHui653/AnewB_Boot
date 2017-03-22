package com.newb.mybatis.db.service.common;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.newb.mybatis.db.entity.User;


import java.util.List;

public abstract class BaseServiceImpl<T> implements IService<T> {

    @Autowired
    protected MyMapper<T> mapper;

    public MyMapper<T> getMapper() {
        return mapper;
    }

    @Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }
    
    @SuppressWarnings("finally")
	@Transactional //事务注解
    public int delete(Object key) {
    	if(key==null){
    		try {
    			User u= (User) mapper.selectByPrimaryKey(4);
        		System.out.println("-------测试事务--还未删除所以能查询-"+u.toString());
    			mapper.deleteByPrimaryKey(4);
        		User u2= (User) mapper.selectByPrimaryKey(4);
        		System.out.println("-------测试事务--已删除在事务中不可读,但还未提交在数据库中可见-"+u2.toString());
        		throw new RuntimeException("test"); 
			} catch (Exception e) {
				System.out.println("测试事务");
			}finally {
				//还未回滚所以查询不出
				User u= (User) mapper.selectByPrimaryKey(4);
				System.out.println("-------测试事务已删除在事务中不可读,但还未提交在数据库中可见---"+u.toString());
				//正式删除,提交至数据库
		        return mapper.deleteByPrimaryKey(key);
			}
    	}
    	//正式删除,提交至数据库
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public List<T> CommonSelMapper(String key) {
        return mapper.CommonSelMapper(key);
    }
    //TODO 其他...
    public int CommonDelMapper(String key) {
        return mapper.CommonDelMapper(key);
    }
}
