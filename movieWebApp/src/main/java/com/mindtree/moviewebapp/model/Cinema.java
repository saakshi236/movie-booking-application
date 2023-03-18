package com.mindtree.moviewebapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Cinema {

	@Id
	@GeneratedValue
	private int id;
	private String cinemaName;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Show> shows;
	@OneToMany(fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Movie> movies;
	@OneToMany(fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Screen> screens;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCinemaName() {
		return cinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
	}
	
	public Cinema(int id, String cinemaName) {
		super();
		this.id = id;
		this.cinemaName = cinemaName;
	}
	public Cinema() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cinemaName == null) ? 0 : cinemaName.hashCode());
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cinema other = (Cinema) obj;
		if (cinemaName == null) {
			if (other.cinemaName != null)
				return false;
		} else if (!cinemaName.equals(other.cinemaName))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
