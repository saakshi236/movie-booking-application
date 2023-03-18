package com.mindtree.moviewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.moviewebapp.model.Cinema;
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {
}
