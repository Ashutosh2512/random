package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public interface QuestionInterface {

	public String getContent();
	public void setContent(String content) ;
	public ArrayList<Post> getAnswers();
	public void setAnswers(ArrayList<Post> answers) ;
	public int getViews() ;
	public void setViews(int views);
	public String getTopic();
	public Date getDate();
	public String getCreatorUserName() ;
	
}
