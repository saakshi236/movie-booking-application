package com.mindtree.moviewebapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userEmail;
	
	@NotNull(message = "Cannot contain null value")
	private String title;
	@NotNull(message = "Cannot contain null value")
	private Date bookingDate;
	@NotNull(message = "Cannot contain null value")
	private String showInfo;
	@NotNull(message = "Cannot contain null value")
	private String theatre;
	@NotNull(message = "Cannot contain null value")
	private String screen;
	@NotNull(message = "Cannot contain null value")
	private int ticketPrice;
		
	public Booking(int id, String userEmail, String title, String showInfo, String theatre, String screen, int ticketPrice) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.title = title;
		this.theatre = theatre;
		this.screen = screen;
		this.showInfo = showInfo;
		this.ticketPrice = ticketPrice;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTheatre() {
		return theatre;
	}
	public void setTheatre(String theatre) {
		this.theatre = theatre;
	}
	public String getScreen() {
		return screen;
	}
	public void setScreen(String screen) {
		this.screen = screen;
	}
	public String getShowInfo() {
		return showInfo;
	}
	public void setShowInfo(String showInfo) {
		this.showInfo = showInfo;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingDate == null) ? 0 : bookingDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((screen == null) ? 0 : screen.hashCode());
		result = prime * result + ((showInfo == null) ? 0 : showInfo.hashCode());
		result = prime * result + ((theatre == null) ? 0 : theatre.hashCode());
		result = prime * result + ticketPrice;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingDate == null) {
			if (other.bookingDate != null)
				return false;
		} else if (!bookingDate.equals(other.bookingDate))
			return false;
		if (id != other.id)
			return false;
		if (screen == null) {
			if (other.screen != null)
				return false;
		} else if (!screen.equals(other.screen))
			return false;
		if (showInfo == null) {
			if (other.showInfo != null)
				return false;
		} else if (!showInfo.equals(other.showInfo))
			return false;
		if (theatre == null) {
			if (other.theatre != null)
				return false;
		} else if (!theatre.equals(other.theatre))
			return false;
		if (ticketPrice != other.ticketPrice)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", userEmail=" + userEmail + ", title=" + title + ", bookingDate=" + bookingDate
				+ ", showInfo=" + showInfo + ", theatre=" + theatre + ", screen=" + screen + ", ticketPrice="
				+ ticketPrice + "]";
	}

	public Booking() {
		super();
	}
}
