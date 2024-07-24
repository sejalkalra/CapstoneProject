package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Showtime;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.MovieRepository;

@Service
public class MovieService implements IMovieService {
	
	
	@Autowired
	    private MovieRepository movieRepository;

	    @Override
	    public Movie saveMovie(Movie movie) {
	        return movieRepository.save(movie);
	    }

	    @Override
	    public Movie updateMovie(Long id, Movie movie)throws ResourceNotFoundException {
	        Movie existingMovie = movieRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
	        existingMovie.setTitle(movie.getTitle());
	        existingMovie.setDescription(movie.getDescription());
	        existingMovie.setGenre(movie.getGenre());
	        existingMovie.setDuration(movie.getDuration());
	        existingMovie.setRating(movie.getRating());
	        return movieRepository.save(existingMovie);
	    }

	    @Override
	    public void deleteMovie(Long id)throws ResourceNotFoundException {
	        Movie existingMovie = movieRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
	        movieRepository.delete(existingMovie);
	    }

	    @Override
	    public Movie getMovieById(Long id)throws ResourceNotFoundException {
	        return movieRepository.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
	    }

	    @Override
	    public List<Movie> getAllMovies() {
	        return movieRepository.findAll();
	    }

	    @Override
	    public Showtime addShowtimeToMovie(Long movieId, Showtime showtime) throws ResourceNotFoundException {
	        Movie movie = movieRepository.findById(movieId)
	                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));
	        showtime.setMovie(movie);
	        movie.getShowtime().add(showtime);
	        movieRepository.save(movie);
	        return showtime;
	    }

	    @Override
	    public List<Showtime> getShowtimesForMovie(Long movieId)throws ResourceNotFoundException {
	        Movie movie = movieRepository.findById(movieId)
	                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));
	        return movie.getShowtime();
	    }

	}


