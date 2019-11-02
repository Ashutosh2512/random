package com.Ashutosh.web.CommunityProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.web.CommunityProject.RepoHandler.ProfileRepository;
import com.Ashutosh.web.CommunityProject.model.Profile;

@Service
public class ProfileServiceImpl {

	@Autowired
	private ProfileRepository pr;
	
	public Profile saveProfile(Profile p) {
		return pr.save(p);
	}
	public Profile updateprofile(Profile p) {
		return pr.save(p);
	}
	public Profile getProfile(String profileId) {
		Optional<Profile> p=pr.findById(profileId);
		if(p.isPresent()) {
			return p.get();
		}
		this.updateViews(profileId);
		return null;
	}
	public List<Profile> getAllProfiles(){
		return pr.findAll();
	}
	public void deleteProfile(String profileId) {
		pr.deleteById(profileId);
	}
	public void addQuestionToProfile(String Topic,String profileId) {
		Profile p=this.getProfile(profileId);
		ArrayList<String> list=p.getQuestions();
		list.add(Topic);
		this.updateprofile(p);
	}
	public void addAnswerToProfile(String TopicID,String profileId) {
		Profile p=this.getProfile(profileId);
		ArrayList<String> list=p.getAnswers();
		list.add(TopicID);
		this.updateprofile(p);
	}
	public Integer updateViews(String profileId) {
		Profile p=this.getProfile(profileId);
		Integer views=p.getProfileViews()+1;
		p.setProfileViews(views);
		this.updateprofile(p);
		return views;
	}
	public String updateContact(String profileId,String Contact) {
		Profile p=this.getProfile(profileId);
		p.setContact(Contact);
		this.updateprofile(p);
		return Contact;
	}
	public String updateEmailId(String profileId,String emailId) {
		Profile p=this.getProfile(profileId);
		p.setEmailId(emailId);
		this.updateprofile(p);
		return emailId;
	}
}
