package com.mindtree.moviewebapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.moviewebapp.exception.AppException;
import com.mindtree.moviewebapp.exception.ResourceNotFoundException;
import com.mindtree.moviewebapp.model.Booking;
import com.mindtree.moviewebapp.model.Movie;
import com.mindtree.moviewebapp.model.Show;
import com.mindtree.moviewebapp.repository.BookingRepository;
import com.mindtree.moviewebapp.repository.MovieRepository;
import com.mindtree.moviewebapp.repository.ShowRepository;

@Transactional  
@Service
public class MovieService {

	@Autowired
	MovieRepository repository;
	
	@Autowired
	ShowRepository showRespository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	public List<Movie> getMovies() throws AppException {
		if(repository.findAll().isEmpty())
			throw new AppException("Exception: No data found");
		return repository.findAll();
	}

	public Optional<Movie> getMovieById(int id) throws ResourceNotFoundException {
		if(!repository.findById(id).isPresent())
			throw new ResourceNotFoundException("Movie", "id", id);
		return repository.findById(id);
	}
	
	public List<Show> showCycleList() throws AppException {
		if(showRespository.findAll().isEmpty())
			throw new AppException("Exception: No data found");
		return showRespository.findAll();
	}

	public String getMovieTitle(int id) throws ResourceNotFoundException {
		if(repository.getTitleById(id) == null)
			throw new ResourceNotFoundException("Title", "id", id);
		return repository.getTitleById(id);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteMovie(int id) {
		if(!repository.findById(id).isPresent())
			throw new ResourceNotFoundException("Movie", "id", id);
		repository.deleteById(id);
	}

	public Optional<Booking> findById(int id) {
		if(!bookingRepository.findById(id).isPresent())
			throw new ResourceNotFoundException("Booking", "id", id);
		return bookingRepository.findById(id);
	}
}
