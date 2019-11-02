package com.Ashutosh.web.CommunityProject.RepoHandler;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Ashutosh.web.CommunityProject.model.likesdislikes;

public interface likesdislikesRepository extends MongoRepository<likesdislikes, String> {

}
