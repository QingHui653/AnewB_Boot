package com.newb.mybatis.db.entity;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class User implements Serializable,Comparable<User>  {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    private Integer oid;

    private String username;

    private String password;
    
    public User() {
		super();
	}

	public User(Integer oid, String username, String password) {
		super();
		this.oid = oid;
		this.username = username;
		this.password = password;
	}
    
    /**
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
	public int compareTo(User o) {
		return this.getOid()-o.getOid();
	}

	@Override
	public String toString() {
		return "User["+oid+","+username+","+password+"]";
	}
    
	@SuppressWarnings("unused")
	private String invMen(String username,String password) {
		return "User["+username+","+password+"]";
	}
}