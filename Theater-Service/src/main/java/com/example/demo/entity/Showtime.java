package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "showtime")
public class Showtime {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long showtimeId;
        private String showDate;
	    private Long movieId;
	    private String showTime;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JsonBackReference
	    @JoinColumn(name = "theaters_id")
	    private Theater theater;
	    private Long theaterId;

		public Long getShowtimeId() {
			return showtimeId;
		}

		public void setShowtimeId(Long showtimeId) {
			this.showtimeId = showtimeId;
		}

		public Long getMovie() {
			return movieId;
		}

		public void setMovie(String movie) {
			this.movieId = movieId;
		}

		public String getShowtime() {
			return showTime;
		}

		public void setShowtime(String showtime) {
			this.showTime = showtime;
		}

		public Theater getTheater() {
			return theater;
		}

		public void setTheater(Theater theater) {
			this.theater = theater;
		}
		
        
		public String getShowDate() {
			return showDate;
		}

		public void setShowDate(String showDate) {
			this.showDate = showDate;
		}

		

		public Long getMovieId() {
			return movieId;
		}

		public void setMovieId(Long movieId) {
			this.movieId = movieId;
		}

		public String getShowTime() {
			return showTime;
		}

		public void setShowTime(String showTime) {
			this.showTime = showTime;
		}

		public Long getTheaterId() {
			return theaterId;
		}

		public void setTheaterId(Long theaterId) {
			this.theaterId = theaterId;
		}

		public Showtime(String showDate, Long movieId, String showTime, Theater theater, Long theaterId) {
			super();
			this.showDate = showDate;
			this.movieId = movieId;
			this.showTime = showTime;
			this.theater = theater;
			this.theaterId = theaterId;
		}

		public Showtime() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
}
