package com.newb.hibernate.db.dao;

import javax.persistence.Table;  

import org.springframework.beans.factory.annotation.Qualifier;  
import org.springframework.data.jpa.repository.Query;  
import org.springframework.data.repository.CrudRepository;  
import org.springframework.data.repository.query.Param;  
import org.springframework.stereotype.Repository;

import com.newb.hibernate.db.entity.User;  
  
@Repository  
@Table(name="user")  
@Qualifier("userRepository")
public interface UserRepository extends CrudRepository<User,Long>{  
	
    public User findByOid(Long id);
  
    @Query("select t from User t where t.username=:name")  
    public User findUserByName(@Param("name") String name);  
}
