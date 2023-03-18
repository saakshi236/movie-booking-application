package com.mindtree.moviewebapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Screen {

	@Id
	@GeneratedValue
	private int id;
	private String screenType;
	private int cinema_id;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Show> shows;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public int getCinemaId() {
		return cinema_id;
	}
	public void setCinemaId(int cinemaId) {
		this.cinema_id = cinemaId;
	}
	
	public Screen(int id, String screenType, int cinemaId) {
		super();
		this.id = id;
		this.screenType = screenType;
		this.cinema_id = cinemaId;
	}
	
	public Screen() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cinema_id;
		result = prime * result + id;
		result = prime * result + ((screenType == null) ? 0 : screenType.hashCode());
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
		Screen other = (Screen) obj;
		if (cinema_id != other.cinema_id)
			return false;
		if (id != other.id)
			return false;
		if (screenType == null) {
			if (other.screenType != null)
				return false;
		} else if (!screenType.equals(other.screenType))
			return false;
		return true;
	}
}
