package com.Ashutosh.web.CommunityProject.Resources;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
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
	public Resource<Question> saveQuestion(@RequestBody Question q) {
		Question q1=qsi.saveQuestion(q);
		Resource<Question> questionResource=new Resource<Question>(q1);
		Link link=ControllerLinkBuilder.linkTo((ControllerLinkBuilder.methodOn(QuestionController.class).getQuestion(q.getTopic()))).withSelfRel();
		questionResource.add(link);
		return questionResource;
	}
	@PutMapping
	public Resource<Question> updateQuestion(@RequestBody Question q) {
		Question q1=qsi.saveQuestion(q);
		Resource<Question> questionResource=new Resource<Question>(q1);
		Link link=ControllerLinkBuilder.linkTo((ControllerLinkBuilder.methodOn(QuestionController.class).getQuestion(q.getTopic()))).withSelfRel();
		questionResource.add(link);
		return questionResource;
	}
	/*
	 * This method saves as well as updates the post if it already exists.
	 */
	@PutMapping(path="{topicId}/posts")
	public Resource<Post> addPost(@RequestBody Post p,@PathVariable(name="topicId") String topicId) {
		p=qsi.addAnswer(topicId, p);
		Link creatorLink=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProfileController.class).getProfile(p.getCreatorUserName())).withRel("creator");
		Resource<Post> postResource=new Resource<Post>(p);
		p.add(creatorLink);
		return postResource;
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
	@PutMapping(path="{topicId}/tags")
	public ArrayList<String> updateQuestionTag(@PathVariable(name="topicId") String topic,@RequestBody ArrayList<String> tag){
		return qsi.updateQuestionTag(tag, topic);
	}
	@GetMapping(path="{topic}")
	public Resource<Question> getQuestion(@PathVariable(name="topic") String topic) {
		Question q= qsi.getQuestion(topic);
		for(Post p:q.getAnswers()) {
			Link link=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProfileController.class).getProfile(p.getCreatorUserName())).withRel("creator");
			p.add(link);
		}
		Resource<Question> resource=new Resource<Question>(q);
		Link link=ControllerLinkBuilder.linkTo((ControllerLinkBuilder.methodOn(QuestionController.class).getQuestion(q.getTopic()))).withSelfRel();
		Link creatorLink=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(ProfileController.class).getProfile(q.getCreatorUserName())).withRel("creator");
		resource.add(link);
		resource.add(creatorLink);
		return resource;
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
