package com.Ashutosh.web.CommunityProject.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashutosh.web.CommunityProject.RepoHandler.ProfileRepository;
import com.Ashutosh.web.CommunityProject.RepoHandler.QuestionRepository;
import com.Ashutosh.web.CommunityProject.model.Post;
import com.Ashutosh.web.CommunityProject.model.Profile;
import com.Ashutosh.web.CommunityProject.model.Question;

@Service
public class questionServiceImpl {
	@Autowired
	private QuestionRepository qr; 
	
	@Autowired
	private ProfileRepository pr;
	
	@Autowired
	private likesdislikesServiceImpl ldsi;
	/*
	 * This method saves the question to database as well as adds 
	 * it to the creator of the profile.
	 */
	public Question saveQuestion(Question q) {
		Optional<Profile> optProfile=pr.findById(q.getCreatorUserName());
		Profile p=optProfile.get();
		ArrayList<String> questions=p.getQuestions();
		questions.add(q.getTopic());
		p.setQuestions(questions);
		pr.save(p);
		return qr.save(q);
	}
	public Question updateQuestion(Question q) {
		return qr.save(q);
	}
	/*
	 * This method saves the post for the question and adds the topicId
	 * to the creator Profile.
	 */
	public Post addAnswer(String topicId,Post p) {
		Optional<Question> optQuestion=qr.findById(topicId);
		Question q=optQuestion.get();
		ArrayList<Post> answers=q.getAnswers();
		if(answers.contains(p)) {
			answers.remove(p);
		}
		answers.add(p);
		q.setAnswers(answers);
		qr.save(q);
		String userName=p.getCreatorUserName();
		Optional<Profile> optProfile=pr.findById(userName);
		Profile profile=optProfile.get();
		ArrayList<String> topicsAnsweredByProfile=profile.getAnswers();
		if(!topicsAnsweredByProfile.contains(topicId)) {
			topicsAnsweredByProfile.add(topicId);
			profile.setAnswers(topicsAnsweredByProfile);
			pr.save(profile);
		}
		ldsi.addNewPost(topicId, p.getCreatorUserName());
		return p;
	}
	public Integer updatePostLike(String topicId,String userName,String likingperson) {
		Optional<Question> optQuestion=qr.findById(topicId);
		Question q=optQuestion.get();
		ArrayList<Post> answers=q.getAnswers();
		Post p=new Post();
		p.setTopicId(topicId);
		p.setCreatorUserName(userName);
		int index=answers.indexOf(p);
		p=answers.get(index);
		List<Integer> likesdislikescount=ldsi.increaseLikesByone(topicId, userName, likingperson);
		p.setLikes(likesdislikescount.get(0));
		p.setDislikes(likesdislikescount.get(1));
		answers.set(index, p);
		q.setAnswers(answers);
		qr.save(q);
		return likesdislikescount.get(0);
	}
	public Integer updatePostDislike(String topicId,String userName,String dislikingperson) {
		Optional<Question> optQuestion=qr.findById(topicId);
		Question q=optQuestion.get();
		ArrayList<Post> answers=q.getAnswers();
		Post p=new Post();
		p.setTopicId(topicId);
		p.setCreatorUserName(userName);
		int index=answers.indexOf(p);
		p=answers.get(index);
		List<Integer> likesAnddislikescount=ldsi.increaseDislikesByone(topicId, userName, dislikingperson);
		p.setLikes(likesAnddislikescount.get(0));
		p.setDislikes(likesAnddislikescount.get(1));
		answers.set(index, p);
		q.setAnswers(answers);
		qr.save(q);
		return likesAnddislikescount.get(1);
	}
	/*
	 * this function gets the question as well as updates the view numbers for question.
	 * But we will need to change viewing mechanism.
	 */
	public Question getQuestion(String topic) {
		Optional<Question> optQuestion=qr.findById(topic);
		if(optQuestion.isPresent()) {
			Question q=optQuestion.get();
			q.setViews(q.getViews()+1);
			qr.save(q);
			return q;
		}
		return null;
	}
	public Integer getPostLikes(String topicId,String userName) {
		return ldsi.getLikes(topicId, userName);
	}
	public Integer getPostDislikes(String topicId,String userName) {
		return ldsi.getDislikes(topicId, userName);
	}
	/*
	 * This method will be use rarely. It has a bug that if the question is removed from the 
	 * repository, the topicId won't be deleted from the answers in profile.  
	 */
	public void deleteQuestion(String topic) {
		Optional<Question> optQuestion=qr.findById(topic);
		Question q=optQuestion.get();
		Optional<Profile> optProfile=pr.findById(q.getCreatorUserName());
		Profile p=optProfile.get();
		ArrayList<String> questions=p.getQuestions();
		questions.remove(topic);
		p.setQuestions(questions);
		pr.save(p);
		qr.deleteById(topic);
	}
	/*
	 * this method deletes the post from the question as well as from the userName
	 */
	public void deleteAnswer(String topicId,String userName) {
		Optional<Question> optQuestion=qr.findById(topicId);
		Question q=optQuestion.get();
		ArrayList<Post> answers=q.getAnswers();
		for(Post p:answers) {
			if(p.getCreatorUserName().equals(userName)) {
				answers.remove(p);
				break;
			}
		}
		q.setAnswers(answers);
		qr.save(q);
		Optional<Profile> optProfile=pr.findById(userName);
		Profile userProfile=optProfile.get();
		ArrayList<String> userAnswers=userProfile.getAnswers();
		userAnswers.remove(topicId);
		userProfile.setAnswers(userAnswers);
		pr.save(userProfile);
	}

}
