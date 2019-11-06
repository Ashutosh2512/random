package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.AccessType.Type;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

@Document(collection="Questions")
public class Question implements QuestionInterface{
	/*
	 * Topic of the question will act as an id here.
	 */
	@Indexed
	@Id
	private String topic;
	@Field
	private String content;
	/*
	 * answers is the list of Post.
	 */
	private ArrayList<Post> answers;
	private ArrayList<String> tags;
	private Date date;
	private Integer views;
	private String creatorUserName;
		
	/*
	 * This class doesn't have any default constructor
	 */
	public Question(ArrayList<String> tags,String topic, String content,
			String creatorUserName) {
		super();
		this.topic = addHyphen(topic);
		this.content = content;
		this.tags=tags;
		this.answers = new ArrayList<Post>();
		this.date = new Date();
		this.views = 0;
		this.creatorUserName = creatorUserName;
	}
	/*
	 * This mehod is used to replace space with hyphen
	 */
	public String addHyphen(String topic) {
		return topic.replace(" ","-");
	}
	/*
	 * This method is used to replace hyphen with space from String
	 */
	public String removeHyphen(String topic) {
		return topic.replace("-", " ");
	}
	public void setTags(ArrayList<String> tags) {
		this.tags=tags;
	}
	public ArrayList<String> getTags(){
		return this.tags;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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