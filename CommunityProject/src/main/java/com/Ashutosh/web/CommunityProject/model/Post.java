package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

public class Post implements PostInterface {


	private String creatorUserName;
	private Date dateOfCreation;
	private Integer likes;
	private Integer dislikes;
	/*
	 * This topicID data is used for retrieval of Post from the Posts DataBase and it's
	 * the topic of the question.
	 */ 
	private String topicID;
	private String content;
	
	public Post(String creatorUserName,
			 String topicID, String content) {
		super();
		this.creatorUserName = creatorUserName;
		this.dateOfCreation = new Date();
		this.likes = 0;
		this.dislikes = 0;
		this.topicID = topicID;
		this.content = content;
	}

	public Post() {
		this.dateOfCreation=new Date();
		this.likes=0;
		this.dislikes=0;
	}
    @Override
	public String getCreatorUserName() {
		return creatorUserName;
	}

	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
	@Override
	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	@Override
	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public Integer getLikes() {
		return likes;
	}
	@Override
	public void setLikes(Integer likes) {
		this.likes = likes;
	}
	@Override
	public Integer getDislikes() {
		return dislikes;
	}
	@Override
	public void setDislikes(Integer dislikes) {
		this.dislikes = dislikes;
	}
	@Override
	public String getTopicId() {
		return topicID;
	}

	public void setTopicId(String topicID) {
		this.topicID = topicID;
	}
	@Override
	public String getContent() {
		return content;
	}
	@Override
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creatorUserName == null) ? 0 : creatorUserName.hashCode());
		result = prime * result + ((topicID == null) ? 0 : topicID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Post p=(Post)obj;
		if(this.creatorUserName.equals(p.getCreatorUserName()) && this.topicID.equals(p.getTopicId())) {
			return true;
		}
		return false;
	}
	
	

}
