package com.mindtree.moviewebapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieWebAppApplication {

	@Bean
	public Logger createLogger() {
		return LoggerFactory.getLogger(MovieWebAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieWebAppApplication.class, args);
	}

}
