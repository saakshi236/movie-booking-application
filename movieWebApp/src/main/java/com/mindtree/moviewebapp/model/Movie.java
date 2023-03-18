package com.mindtree.moviewebapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;

	@Column(name = "releaseDate")
	private Date releaseDate;

	private String showCycle;
	
	@OneToMany(mappedBy = "showCycle", fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Show> shows;
	@OneToMany(fetch = FetchType.LAZY)
	@JsonBackReference
	private List<Screen> screens;	

	public Movie() {
	}

	public Movie(String title, Date releaseDate, String showCycle) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.showCycle = showCycle;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getShowCycle() {
		return showCycle;
	}

	public void setShowCycle(String showCycle) {
		this.showCycle = showCycle;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((showCycle == null) ? 0 : showCycle.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (showCycle == null) {
			if (other.showCycle != null)
				return false;
		} else if (!showCycle.equals(other.showCycle))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
