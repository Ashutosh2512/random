package com.Ashutosh.web.CommunityProject.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ashutosh.web.CommunityProject.Service.ProfileServiceImpl;
import com.Ashutosh.web.CommunityProject.model.Profile;

@RestController
@RequestMapping(path="profiles")
public class ProfileController {

	@Autowired
	private ProfileServiceImpl prsi;
	
	@PostMapping
	public Profile saveProfile(@RequestBody Profile p) {
		return prsi.saveProfile(p);
	}
	
	@PutMapping
	public Profile updateProfile(@RequestBody Profile p) {
		return prsi.updateprofile(p);
	}
	@GetMapping(path="{profileId}")
	public Profile getProfile(@PathVariable(name="profileId") String id) {
		return prsi.getProfile(id);
	}
	@GetMapping
	public List<Profile> getAllProfiles(){
		return prsi.getAllProfiles();
	}
	@DeleteMapping(path="{profileId}")
	public void deleteProfile(@PathVariable(name="profileId") String id) {
		prsi.deleteProfile(id);
	}
	@PutMapping(path="{profileId}/question")
	public void addQuestionToprofile(@RequestBody String Question,@PathVariable(name="profileId") String profileId) {
		prsi.addQuestionToProfile(Question, profileId);
	}
	@PutMapping(path="{profileId}/answer")
	public void addAnswerToprofile(@RequestBody String Question,@PathVariable(name="profileId") String profileId) {
		prsi.addAnswerToProfile(Question, profileId);
	}
	//Increases the view of the profile by 1
	@PutMapping(path="{profileId}/views")
	public Integer updateProfileViews(@PathVariable(name="profileId") String profileId) {
		return prsi.updateViews(profileId);
	}
	@PutMapping(path="{profileId}/contact")
	public String updateContact(@RequestBody String contact,@PathVariable(name="profileId") String profileId) {
		return prsi.updateContact(profileId, contact);
	}
	@PutMapping(path="{profileId}/emailId")
	public String updateEmailId(@RequestBody String emailId,@PathVariable(name="profileId") String profileId) {
		return prsi.updateEmailId(profileId, emailId);
	}
	
}
