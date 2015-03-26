package org.springframework.mystudy.model;

import java.io.Serializable;

public class UserModel implements Serializable{
	private static final long serialVersionUID = 5895776147474540448L;
	
	private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}