package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface ProfileInterface {
	public String getEmailId();
	public void setEmailId(String emailId);
	public String getContact() ;
	public void setContact(String contact);
	public ArrayList<String> getQuestions() ;
	public void setQuestions(ArrayList<String> questions);
	public ArrayList<String> getAnswers() ;
	public void setAnswers(ArrayList<String> answers);
	public int getProfileViews();
	public void setProfileViews(int profileViews);
	public String getId();
	public String getName();
	public Date getDob() ;
}
