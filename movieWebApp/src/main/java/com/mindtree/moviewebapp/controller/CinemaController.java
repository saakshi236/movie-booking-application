package com.mindtree.moviewebapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.moviewebapp.exception.AppException;
import com.mindtree.moviewebapp.model.Booking;
import com.mindtree.moviewebapp.model.Cinema;
import com.mindtree.moviewebapp.model.Screen;
import com.mindtree.moviewebapp.model.Show;
import com.mindtree.moviewebapp.service.CinemaService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CinemaController {
	
	@Autowired
	private Logger logger;
	
	@Autowired
	CinemaService service;
	
	@GetMapping("/listShows")
	public List<Show> getShowList() throws AppException{
		logger.info("Log -> Records returned: "+service.fetchShowList().size());
		return service.fetchShowList();
	}
	
	@PostMapping("/saveBooking")
	public Booking saveBooking(@Valid @RequestBody Booking booking) {
		logger.info("Log -> Request for saving record: "+booking.toString());
		service.saveBooking(booking);
		return booking;
	}
	
	@GetMapping("/bookingsList")
	public List<Booking> getBookingsList() throws AppException{
		logger.info("Log -> Records returned: "+service.fetchBookingList().size());
		return service.fetchBookingList();
	}
	
	@DeleteMapping("/bookMovie/{id}")
	public void deleteBooking(@PathVariable int id){
		logger.info("Log -> Request for deleting record with id: "+id);
		service.deleteBooking(id);
	}
	
	@GetMapping("/cinemaNameList")
	public List<Cinema> getcinemaNameList() throws AppException{
		logger.info("Log -> Records returned: "+service.fetchcinemaNameList().size());
		return service.fetchcinemaNameList();
	}
	
	@PostMapping
	public void loadScreenList(@RequestBody Cinema cinema) {
		int id = cinema.getId();
		System.err.println(id);
	}
	
	@GetMapping("/screenType")
	public List<Screen> getScreenType() throws AppException{
		logger.info("Log -> Records returned: "+service.fetchScreenType().size());
		return service.fetchScreenType();
	}
}
