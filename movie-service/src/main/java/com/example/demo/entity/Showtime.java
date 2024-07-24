package com.example.demo.entity;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "showtime")
public class Showtime {
	  @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "showtime_id")
    private Long showtimeId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

//    @ManyToOne
//    @JoinColumn(name = "theater_id")
//    private Theater theater;

    @Column(name = "show_date")
    private String showDate;

    @Column(name = "show_time")
    private String showTime;

    // One-to-Many relationship with Booking
//    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
//    private List<Booking> bookings;

	public Long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Long showtimeId) {
		this.showtimeId = showtimeId;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

//	public Theater getTheater() {
//		return theater;
//	}
//
//	public void setTheater(Theater theater) {
//		this.theater = theater;
//	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	public String getShowTime() {
		return showTime;
	}

	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}

//	public List<Booking> getBookings() {
//		return bookings;
//	}
//
//	public void setBookings(List<Booking> bookings) {
//		this.bookings = bookings;
//	}


	public Showtime(Long showtimeId, Movie movie,  String showDate, String showTime) {
		super();
		this.showtimeId = showtimeId;
		this.movie = movie;
		//this.theater = theater;
		this.showDate = showDate;
		this.showTime = showTime;
		//this.bookings = bookings;
	}

	public Showtime() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
