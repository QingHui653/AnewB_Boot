package com.newb.hibernate.db.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity  
@Table(name="user")
public class User {  
	@Id  
	@GeneratedValue(strategy=GenerationType.AUTO)  
	@Column(name="oid")  
    private Integer oid ;
	
	@Column(name="username")  
    private String username;  
	
	@Column(name="password")  
    private String password ;  
  
}  
