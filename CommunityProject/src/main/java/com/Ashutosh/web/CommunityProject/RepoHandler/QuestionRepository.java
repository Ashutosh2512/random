package com.Ashutosh.web.CommunityProject.RepoHandler;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Ashutosh.web.CommunityProject.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {

}
