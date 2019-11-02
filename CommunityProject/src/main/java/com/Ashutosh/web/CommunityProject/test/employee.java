package com.Ashutosh.web.CommunityProject.test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="employees")
public class employee {
	@Id
	private String id;
	@Field(value="userName")
	private String userName;
	@Field(value="designation")
	private String designation;
	
	public employee(String userName,String designation) {
		super();
		this.userName = userName;
		this.designation=designation;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}