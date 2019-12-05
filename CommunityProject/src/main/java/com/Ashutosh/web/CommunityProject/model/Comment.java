package com.Ashutosh.web.CommunityProject.model;

import java.util.Date;

public class Comment {
	private Date date;
	private String creatorUserName;
	private String content;
	
	public Comment(String creatorUserName,String content) {
		this.creatorUserName=creatorUserName;
		this.content=content;
		this.date=new Date();
	}
   
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	
	
}
