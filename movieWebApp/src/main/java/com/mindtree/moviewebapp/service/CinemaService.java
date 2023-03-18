package com.mindtree.moviewebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.moviewebapp.exception.AppException;
import com.mindtree.moviewebapp.exception.ResourceNotFoundException;
import com.mindtree.moviewebapp.model.Booking;
import com.mindtree.moviewebapp.model.Cinema;
import com.mindtree.moviewebapp.model.Screen;
import com.mindtree.moviewebapp.model.Show;
import com.mindtree.moviewebapp.repository.BookingRepository;
import com.mindtree.moviewebapp.repository.CinemaRepository;
import com.mindtree.moviewebapp.repository.ScreenRepository;
import com.mindtree.moviewebapp.repository.ShowRepository;

@Transactional
@Service
public class CinemaService {
	
	@Autowired
	ShowRepository showRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	ScreenRepository screenRepository;

	public List<Show> fetchShowList() throws AppException {
		if(showRepository.findAll().isEmpty())
			throw new AppException("Exception: No records found");
		return showRepository.findAll();
	}

	@Transactional
	public void saveBooking(Booking booking) {
		bookingRepository.save(booking);
	}

	public List<Booking> fetchBookingList() throws AppException {
		if(bookingRepository.findAll().isEmpty())
			throw new AppException("Exception: No records found");
		return bookingRepository.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteBooking(int id) {
		if(!bookingRepository.findById(id).isPresent())
			throw new ResourceNotFoundException("Booking", "id", id);
		bookingRepository.deleteById(id);
	}

	public List<Cinema> fetchcinemaNameList() throws AppException {
		if(cinemaRepository.findAll().isEmpty())
			throw new AppException("Exception: No records found");
		return cinemaRepository.findAll();
	}

	public List<Screen> fetchScreenType() throws AppException {
		if(screenRepository.findAll().isEmpty())
			throw new AppException("Exception: No records found");
		return screenRepository.findAll();
	}
}
