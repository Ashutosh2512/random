package com.Ashutosh.web.CommunityProject.test;

import java.util.List;



public interface entityService {

	public employee save(employee e);
	public employee update(employee e);
	public employee getEntity(String id);
	public List<employee> getAllEntity();
	public void deleteEntity(String id);
}
