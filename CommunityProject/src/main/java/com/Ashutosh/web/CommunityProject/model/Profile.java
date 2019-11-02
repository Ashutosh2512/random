package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="Profiles")
public class Profile implements ProfileInterface{
	/*
	 * id is the userName, as it is unique.
	 */
	@Id
	private String id;
	@Field(value="emailId")
	private String emailId;
	@Field(value="name")
	private String name;
	@Field(value="contact")
	private String contact;
	@Field(value="dob")
	private Date dob;
	/*
	 * The answers is a list of Question topics whose answer the user provided.
	 * List<PostTopic>.
	 * Similarly, questions is a list of questions which the profile asked
	 */
	@Field(value="questions")	
	private ArrayList<String> questions;
	@Field(value="answers")
	private ArrayList<String> answers;
	@Field(value="profileViews")
	private Integer profileViews;
	
	
	
	public Profile(String username, String emailId, String name, String contact, Date dob) {
		super();
		this.id = username;
		this.emailId = emailId;
		this.name = name;
		this.contact = contact;
		this.dob = dob;
		this.questions = new ArrayList<String>();
		this.answers = new ArrayList<String>();
		this.profileViews = 0;
	}
	
	public Profile() {
		this.profileViews=0;
		this.answers=new ArrayList<String>();
		this.questions=new ArrayList<String>();
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public ArrayList<String> getQuestions() {
		return questions;
	}



	public void setQuestions(ArrayList<String> questions) {
		this.questions = questions;
	}



	public ArrayList<String> getAnswers() {
		return answers;
	}



	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}



	public int getProfileViews() {
		return profileViews;
	}



	public void setProfileViews(int profileViews) {
		this.profileViews = profileViews;
	}
	
}

