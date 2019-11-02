package com.Ashutosh.web.CommunityProject.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.web.CommunityProject.Service.questionServiceImpl;
import com.Ashutosh.web.CommunityProject.model.Post;
import com.Ashutosh.web.CommunityProject.model.Question;

@RestController
@RequestMapping(path="questions")
public class QuestionController {
	@Autowired
	private questionServiceImpl qsi;
	
	@PostMapping
	public Question saveQuestion(@RequestBody Question q) {
		return qsi.saveQuestion(q);
	}
	@PutMapping
	public Question updateQuestion(@RequestBody Question q) {
		return qsi.updateQuestion(q);
	}
	/*
	 * This method saves as well as updates the post if it already exists.
	 */
	@PutMapping(path="{topicId}/posts")
	public Post addPost(@RequestBody Post p,@PathVariable(name="topicId") String topicId) {
		return qsi.addAnswer(topicId, p);
	}
	/*
	 * this method is used to update the likes of the post
	 */
	@PutMapping(path="{topicId}/posts/{userName}/likes")
	public Integer postLikesUpdate(@RequestBody String likingperson,@PathVariable(name="topicId") String topicId,@PathVariable(name="userName") String userName) {
		return qsi.updatePostLike(topicId, userName,likingperson);
	}
	/*
	 * this method is used to update the dislikes of the post
	 */
	@PutMapping(path="{topicId}/posts/{userName}/dislikes")
	public Integer postDislikesUpdate(@RequestBody String dislikingperson,@PathVariable(name="topicId") String topicId,@PathVariable(name="userName") String userName) {
		return qsi.updatePostDislike(topicId, userName,dislikingperson);
	}
	@GetMapping(path="{topic}")
	public Question getQuestion(@PathVariable(name="topic") String topic) {
		return qsi.getQuestion(topic);
	}
	@GetMapping(path="{topicId}/posts/{postCreatorName}/likes")
	public Integer getLikes(@PathVariable(name="topicId") String topicId,@PathVariable(name="postCreatorName") String userName) {
		return qsi.getPostLikes(topicId, userName);
	}
	@GetMapping(path="{topicId}/posts/{postCreatorName}/dislikes")
	public Integer getDislikes(@PathVariable(name="topicId") String topicId,@PathVariable(name="postCreatorName") String userName) {
		return qsi.getPostDislikes(topicId, userName);
	}
	@DeleteMapping(path="{topic}")
	public void deleteQuestion(@PathVariable(name="topic") String topic) {
		qsi.deleteQuestion(topic);
	}
	@DeleteMapping(path="{topicId}/posts/{userName}")
	public void deletePost(@PathVariable(name="topicId") String topicId,@PathVariable(name="userName") String userName) {
		qsi.deleteAnswer(topicId, userName);
	}
}
