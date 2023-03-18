package com.mindtree.moviewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.moviewebapp.model.Booking;
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	Booking findByUserEmail(String emailId);
}
