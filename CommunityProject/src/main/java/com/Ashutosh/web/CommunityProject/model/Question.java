package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Questions")
public class Question implements QuestionInterface{
	/*
	 * Topic of the question will act as an id here.
	 */
	@Id
	private String topic;
	@Field
	private String content;
	/*
	 * answers is the list of Post.
	 */
	private ArrayList<Post> answers;
	private Date date;
	private Integer views;
	private String creatorUserName;
		
	public Question(String topic, String content,
			String creatorUserName) {
		super();
		this.topic = topic;
		this.content = content;
		this.answers = new ArrayList<Post>();
		this.date = new Date();
		this.views = 0;
		this.creatorUserName = creatorUserName;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		content = content;
	}
	public ArrayList<Post> getAnswers() {
		return this.answers;
	}
	public void setAnswers(ArrayList<Post> answers) {
		this.answers = answers;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic=topic;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date=date;
	}
	public String getCreatorUserName() {
		return creatorUserName;
	}
	public void setCreatorUserName(String creatoruserName) {
		this.creatorUserName=creatoruserName;
	}
	
}