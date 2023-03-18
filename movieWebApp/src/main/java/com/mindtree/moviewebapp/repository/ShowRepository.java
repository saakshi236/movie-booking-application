package com.mindtree.moviewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.moviewebapp.model.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {

}
