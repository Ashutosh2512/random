package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="LikesDislikes")
public class likesdislikes {
	/*
	 * creator of the post
	 */
	@Id
	private String creatorUserNameAndtopicId;
	/*
	 * list of users who have liked or disliked the post
	 */
	@Field
	private ArrayList<String> likes;
	@Field
	private ArrayList<String> dislikes;
	
	public likesdislikes() {
		
	}
	public likesdislikes(String creatorUserNameAndtopicId) {
		this.creatorUserNameAndtopicId=creatorUserNameAndtopicId;
		this.dislikes=new ArrayList<String>();
		this.likes=new ArrayList<String>();
	}
	
	public String getCreatorUserNameAndtopicId() {
		return creatorUserNameAndtopicId;
	}
	public void setCreatorUserNameAndtopicId(String creatorUserNameAndtopicId) {
		this.creatorUserNameAndtopicId = creatorUserNameAndtopicId;
	}
	public ArrayList<String> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}
	public ArrayList<String> getDislikes() {
		return dislikes;
	}
	public void setDislikes(ArrayList<String> dislikes) {
		this.dislikes = dislikes;
	}
	
	
}
