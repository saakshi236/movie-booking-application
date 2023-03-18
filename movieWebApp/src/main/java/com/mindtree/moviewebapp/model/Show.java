package com.mindtree.moviewebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieShow")
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String showCycle;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShowCycle() {
		return showCycle;
	}
	public void setShowCycle(String showCycle) {
		this.showCycle = showCycle;
	}
	
	public Show(int id, String showCycle) {
		super();
		this.id = id;
		this.showCycle = showCycle;
	}
	
	public Show() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((showCycle == null) ? 0 : showCycle.hashCode());
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
		Show other = (Show) obj;
		if (id != other.id)
			return false;
		if (showCycle == null) {
			if (other.showCycle != null)
				return false;
		} else if (!showCycle.equals(other.showCycle))
			return false;
		return true;
	}
}
