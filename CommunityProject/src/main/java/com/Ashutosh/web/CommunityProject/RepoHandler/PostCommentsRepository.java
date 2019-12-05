package com.Ashutosh.web.CommunityProject.RepoHandler;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Ashutosh.web.CommunityProject.model.PostComments;

public interface PostCommentsRepository extends MongoRepository<PostComments, String> {

}
