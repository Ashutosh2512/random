package com.Ashutosh.web.CommunityProject.RepoHandler;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Ashutosh.web.CommunityProject.model.Profile;

public interface ProfileRepository extends MongoRepository<Profile, String> {

}
