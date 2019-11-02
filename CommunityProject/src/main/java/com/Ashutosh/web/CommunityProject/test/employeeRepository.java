package com.Ashutosh.web.CommunityProject.test;

import org.springframework.data.mongodb.repository.MongoRepository;




public interface employeeRepository extends MongoRepository<employee, String> {

}
