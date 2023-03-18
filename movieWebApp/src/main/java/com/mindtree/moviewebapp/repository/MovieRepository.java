package com.mindtree.moviewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.moviewebapp.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	String getTitleById(int id);
}
