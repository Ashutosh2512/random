package com.Ashutosh.web.CommunityProject.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="PostComments")
public class PostComments {
	/*
	 * id=QuestionTopic+"-"+PostCreator
	 */
	@Indexed
	@Id
	private String id;
	@Field
	private ArrayList<Comment> allComments;
	
	public PostComments(String id) {
		this.id=id;
		allComments=new ArrayList<Comment>();
	}
	//empty Constructor
	public PostComments() {
		
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Comment> getAllComments() {
		return allComments;
	}

	public void setAllComments(ArrayList<Comment> allComments) {
		this.allComments = allComments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostComments other = (PostComments) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
