package com.mindtree.moviewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.moviewebapp.model.Screen;
public interface ScreenRepository extends JpaRepository<Screen, Integer> {
}
