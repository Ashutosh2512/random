package com.Ashutosh.web.CommunityProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.web.CommunityProject.RepoHandler.likesdislikesRepository;
import com.Ashutosh.web.CommunityProject.model.likesdislikes;

@Service
public class likesdislikesServiceImpl {
	@Autowired
	private likesdislikesRepository ldr;
	/*
	 * used whenever a new post is created or updated
	 */
	public void addNewPost(String topicId,String userName) {
		String s=userName+topicId;
		ldr.save(new likesdislikes(s));
	}
	public Integer getLikes(String topicId,String userName) {
		String s=userName+topicId;
		Optional<likesdislikes> optlikesdislikes=ldr.findById(s);
		likesdislikes ld=optlikesdislikes.get();
		return ld.getLikes().size();
	}
	public Integer getDislikes(String topicId,String userName) {
		String s=userName+topicId;
		Optional<likesdislikes> optlikesdislikes=ldr.findById(s);
		likesdislikes ld=optlikesdislikes.get();
		return ld.getDislikes().size();
	}
	public List<Integer> increaseLikesByone(String topicId,String userName,String likingperson) {
		String s=userName+topicId;
		Optional<likesdislikes> optlikesdislikes=ldr.findById(s);
		likesdislikes ld=optlikesdislikes.get();
		ArrayList<String> likes=ld.getLikes();
		
		ArrayList<String> dislikes=ld.getDislikes();
		ArrayList<Integer> likesAnddislikes=new ArrayList<Integer>();
		if(dislikes.contains(likingperson)) {
			dislikes.remove(likingperson);
		}
		if(likes.contains(likingperson)) {
			likesAnddislikes.add(likes.size());
			likesAnddislikes.add(dislikes.size());
			return likesAnddislikes;
		}
		likes.add(likingperson);
		ld.setLikes(likes);
		ld.setDislikes(dislikes);
		ldr.save(ld);
		likesAnddislikes.add(likes.size());
		likesAnddislikes.add(dislikes.size());
		return likesAnddislikes;
	}
	public List<Integer> increaseDislikesByone(String topicId,String userName,String dislikingperson) {
		String s=userName+topicId;
		Optional<likesdislikes> optlikesdislikes=ldr.findById(s);
		likesdislikes ld=optlikesdislikes.get();
		ArrayList<String> likes=ld.getLikes();
		
		ArrayList<String> dislikes=ld.getDislikes();
		ArrayList<Integer> likesAnddislikes=new ArrayList<Integer>();
		if(likes.contains(dislikingperson)) {
			likes.remove(dislikingperson);
		}
		if(dislikes.contains(dislikingperson)) {
			likesAnddislikes.add(likes.size());
			likesAnddislikes.add(dislikes.size());
			return likesAnddislikes;
		}
		dislikes.add(dislikingperson);
		ld.setDislikes(dislikes);
		ld.setLikes(likes);
		ldr.save(ld);
		likesAnddislikes.add(likes.size());
		likesAnddislikes.add(dislikes.size());
		return likesAnddislikes;
	}
}
