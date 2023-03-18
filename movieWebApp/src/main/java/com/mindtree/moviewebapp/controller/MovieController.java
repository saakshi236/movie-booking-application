package com.mindtree.moviewebapp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.moviewebapp.exception.AppException;
import com.mindtree.moviewebapp.exception.ResourceNotFoundException;
import com.mindtree.moviewebapp.model.Booking;
import com.mindtree.moviewebapp.model.Movie;
import com.mindtree.moviewebapp.service.MovieService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class MovieController {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	MovieService service;
	
	@GetMapping("/movies")
	public List<Movie> getMovieDetails() throws AppException {
		logger.info("Log -> Records returned: "+service.getMovies().size());
		return service.getMovies();
	}
	
	@GetMapping("/bookMovie/{id}") 
	public Optional<Movie> getMovieDetail(@PathVariable int id) throws ResourceNotFoundException{
		return service.getMovieById(id);
	}

	@PutMapping("/booking/{id}")
	public Optional<Booking> updateMovie(@PathVariable int id) {
		logger.info("Log -> Request for update of booking with id: "+id);
		return service.findById(id);
	}
}
