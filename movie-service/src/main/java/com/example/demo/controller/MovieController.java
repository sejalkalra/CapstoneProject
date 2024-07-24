package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Movie;
import com.example.demo.entity.Showtime;
import com.example.demo.service.IMovieService;
import com.example.demo.service.MovieService;

	@RestController
	@RequestMapping("/api/movies")
	public class MovieController {

	    @Autowired
	    private IMovieService movieService;
	  
	    @PostMapping
	    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
	        return ResponseEntity.ok(movieService.saveMovie(movie));
	    }
	  
	    @PutMapping("/{id}")
	    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody Movie movie) {
	        return ResponseEntity.ok(movieService.updateMovie(id, movie));
	    }

	 
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
	        movieService.deleteMovie(id);
	        return ResponseEntity.noContent().build();
	    }
	  
	    @GetMapping("/{id}")
	    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
	        return ResponseEntity.ok(movieService.getMovieById(id));
	    }
	  
	    @GetMapping
	    public ResponseEntity<List<Movie>> getAllMovies() {
	        return ResponseEntity.ok(movieService.getAllMovies());
	    }

	   
	    @PostMapping("/{id}/showtimes")
	    public ResponseEntity<Showtime> addShowtimeToMovie(@PathVariable Long id, @RequestBody Showtime showtime) {
	        return ResponseEntity.ok(movieService.addShowtimeToMovie(id, showtime));
	    }

	    @GetMapping("/showtimes/{id}")
	    public ResponseEntity<List<Showtime>> getShowtimesForMovie(@PathVariable Long id) {
	        return ResponseEntity.ok(movieService.getShowtimesForMovie(id));
	    }
	}

