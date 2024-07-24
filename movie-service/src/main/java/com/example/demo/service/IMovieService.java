package com.example.demo.service;
import java.util.List;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Showtime;

public interface IMovieService {
	
       Movie saveMovie(Movie movie);

	    Movie updateMovie(Long id, Movie movie);

	    void deleteMovie(Long id);

	    Movie getMovieById(Long id);

	    List<Movie> getAllMovies();

	    // Showtime-specific operations
	    Showtime addShowtimeToMovie(Long movieId, Showtime showtime);

	    List<Showtime> getShowtimesForMovie(Long movieId);
	}


