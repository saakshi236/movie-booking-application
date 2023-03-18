package com.mindtree.moviewebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.moviewebapp.model.User;
import com.mindtree.moviewebapp.repository.RegistrationRepository;

@Transactional
@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repository;
	
	@Transactional
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User fetchByEmailId(String email) {
		return repository.findByEmailId(email);
	}

	public boolean validateUser(User currentUser, User user) {
		if(currentUser.getPassword().equals(user.getPassword()))
			return true;
		return false;
	}

	public User validateUserInput(User user) throws Exception {
		String tempEmail = user.getEmailId();
		if(tempEmail!= null && !"".equals(tempEmail)) {
			User tempUserObj = repository.findByEmailId(tempEmail);
			if(tempUserObj != null) {
				throw new Exception("User with "+tempEmail+" already exists!");
			}
		}
		return null;
	}	
}
