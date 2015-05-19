package org.springframework.mystudy.model;

import java.io.Serializable;

public class UserModel implements Serializable{
	private static final long serialVersionUID = 5895776147474540448L;
	
	private Integer id;
	private String username;
    private String password;
    private String email;
	private Integer sex;
    
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
}