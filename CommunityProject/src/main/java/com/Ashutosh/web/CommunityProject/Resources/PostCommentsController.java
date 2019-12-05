package com.Ashutosh.web.CommunityProject.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.web.CommunityProject.Service.PostCommentsService;
import com.Ashutosh.web.CommunityProject.model.Comment;
@RestController
@RequestMapping(path="comments")
public class PostCommentsController {

	@Autowired
	private PostCommentsService pcs;
	
	@PostMapping(path="/{PostcommentId}")
	public Comment addcomment(@RequestBody Comment c,@PathVariable(name="PostcommentId") String PostcommentId) {
		return pcs.addComment(PostcommentId, c);
	}
	@GetMapping(path="/{PostCommentId}")
	public List<Comment> getAllComments(@PathVariable(name="PostCommentId") String PostCommentId){
		return pcs.getAllComments(PostCommentId);
	}
	@PutMapping(path="/{PostCommentId}")
	public Comment updateComment(@PathVariable(name="PostCommentId") String PostCommentId,Comment c) {
		return pcs.updateComment(PostCommentId, c);
	}
	
}
