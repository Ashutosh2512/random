package com.Ashutosh.web.CommunityProject.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class entityServiceImpl implements entityService {
	@Autowired
	private employeeRepository repository;
	
	@Override
	public employee save(employee e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

	@Override
	public employee update(employee e) {
		// TODO Auto-generated method stub
		return repository.save(e);
	}

	@Override
	public employee getEntity(String id) {
		// TODO Auto-generated method stub
		Optional<employee> OptUser=repository.findById(id);
		if(OptUser.isPresent()) {
			return OptUser.get();
		}
		return null;
	}

	@Override
	public List<employee> getAllEntity() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void deleteEntity(String id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}