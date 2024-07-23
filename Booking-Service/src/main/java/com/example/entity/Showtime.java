package com.example.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "showtime")
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long showtimeId;
    private String showtimeDate;

    @OneToMany(mappedBy = "showtime")
    //@JsonManagedReference
    private List<Booking> bookings;

    
    
    
	public Showtime() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Showtime(String showtimeDate, List<Booking> bookings) {
		super();
		this.showtimeDate = showtimeDate;
		this.bookings = bookings;
	}


	public Long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public String getShowtimeDate() {
		return showtimeDate;
	}

	public void setShowtimeDate(String showtimeDate) {
		this.showtimeDate = showtimeDate;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

    
}
