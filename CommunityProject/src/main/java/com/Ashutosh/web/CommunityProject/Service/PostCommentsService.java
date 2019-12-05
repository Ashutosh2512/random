package com.Ashutosh.web.CommunityProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.web.CommunityProject.RepoHandler.PostCommentsRepository;
import com.Ashutosh.web.CommunityProject.model.Comment;
import com.Ashutosh.web.CommunityProject.model.PostComments;
@Service
public class PostCommentsService {

	@Autowired
	private PostCommentsRepository pcr;
	
	public Comment addComment(String PostCommentId,Comment c) {
		PostComments pc=pcr.findById(PostCommentId).get();
		ArrayList<Comment> commentslist=pc.getAllComments();
		commentslist.add(c);
		pc.setAllComments(commentslist);
		pcr.save(pc);
		return c;
	}
	public List<Comment> getAllComments(String PostCommentsId){
		return pcr.findById(PostCommentsId).get().getAllComments();
	}
	public Comment updateComment(String PostCommentId,Comment c) {
		PostComments pc=pcr.findById(PostCommentId).get();
		ArrayList<Comment> commentslist=pc.getAllComments();
		if(commentslist.contains(c)) {
			int index=commentslist.indexOf(c);
			commentslist.remove(c);
			commentslist.add(index, c);
		}
		return c;
	}
}
