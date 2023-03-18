package com.mindtree.moviewebapp.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.moviewebapp.model.User;
import com.mindtree.moviewebapp.service.RegistrationService;

@CrossOrigin("http://localhost:4200")
@RestController
public class RegistrationController {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	private RegistrationService service;
	
	@PostMapping("/registerUser")
	public User registerUser(@RequestBody User user) throws Exception{
		logger.info("Log -> Request for saving record: "+user.toString());
		return service.saveUser(service.validateUserInput(user));
	}

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User user){
		logger.info("LOG --> User Validation Request Received: "+this.getClass().getSimpleName());
		User currentUser = service.fetchByEmailId(user.getEmailId());
		if(currentUser == null)
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		if(service.validateUser(currentUser, user))
			return ResponseEntity.ok(user);
		return (ResponseEntity<?>) ResponseEntity.internalServerError();
	}
}
