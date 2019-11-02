package com.Ashutosh.web.CommunityProject.test;

import java.util.List;
import java.util.Optional;

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



@RestController
@RequestMapping(path="entities")
public class entityController {

	@Autowired
	private entityServiceImpl impl;
	
	@GetMapping
	public String helloworld() {
		return "helloWorld";
	}
	@PostMapping(path="save")
	public employee save(@RequestBody employee e) {
		return impl.save(e);
	}
	
	@PutMapping(path="update")
	public employee update(@RequestBody employee e) {
		return impl.update(e);
	}
	
	@GetMapping(path="getAll")
	public List<employee> getAll(){
		return impl.getAllEntity();
	}
	
	@GetMapping
	@RequestMapping(path="get/{id}")
	public Resource<employee> getOne(@PathVariable(name="id") String id) {
		employee e=impl.getEntity(id);
		Resource<employee> resource=new Resource<employee>(e);
		Link link=ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(entityController.class).getOne(e.getId())).withSelfRel();
		resource.add(link);
		return resource;
	}
	
	@DeleteMapping(path="delete/{id}")
	public void delete(@PathVariable(name="id") String id) {
		impl.deleteEntity(id);
	}
}