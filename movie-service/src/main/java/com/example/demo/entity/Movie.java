package com.example.demo.entity;
	import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "movie")
	public class Movie {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long movieId;
	    private String title;
	    private String description;
	    private String genre;
	    private int duration;
	    private double rating;

	    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Showtime> showtime;

		public Long getMovieId() {
			return movieId;
		}

		public void setMovieId(Long movieId) {
			this.movieId = movieId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getGenre() {
			return genre;
		}

		public void setGenre(String genre) {
			this.genre = genre;
		}

		public int getDuration() {
			return duration;
		}

		public void setDuration(int duration) {
			this.duration = duration;
		}

		public double getRating() {
			return rating;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public List<Showtime> getShowtime() {
			return showtime;
		}

		public void setShowtime(List<Showtime> showtime) {
			this.showtime = showtime;
		}


		public Movie(Long movieId, String title, String description, String genre, int duration, double rating,
				List<Showtime> showtime) {
			super();
			this.movieId = movieId;
			this.title = title;
			this.description = description;
			this.genre = genre;
			this.duration = duration;
			this.rating = rating;
			this.showtime = showtime;
		}

		public Movie() {
			super();
			// TODO Auto-generated constructor stub
		}

		
	}


