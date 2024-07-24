package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Movie;
import com.example.entity.Showtime;
import com.example.entity.Theater;
import com.example.repository.MovieRepository;
import com.example.repository.ShowtimeRepository;
import com.example.repository.TheaterRepository;

@Service
public class ShowtimeService implements IShowtimeService {

    @Autowired
    private ShowtimeRepository showtimeRepository;

    @Autowired
    private MovieRepository movieRepo;
    
    @Autowired
    private TheaterRepository theaterRepo;
    

    @Override
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    @Override
    public Optional<Showtime> getShowtimeById(Long id) {
        return showtimeRepository.findById(id);
    }

    @Override
    public Showtime saveShowtime(Showtime showtime) {
    	Movie movie = movieRepo.findById(showtime.getMovieId()).get();
    	Theater theater = theaterRepo.findById(showtime.getTheaterId()).get();
    	showtime.setMovie(movie);
    	showtime.setTheater(theater);
        return showtimeRepository.save(showtime);
    }

    @Override
    public void deleteShowtime(Long id) {
        showtimeRepository.deleteById(id);
    }
    
    @Override
    public Showtime updateShowtime(Long id, Showtime showtime) {
        showtime.setShowtimeId(id);
        return showtimeRepository.save(showtime);
    }
    
    @Override
    public List<Showtime> getShowtimesByTheaterId(Long theaterId) {
        return showtimeRepository.findByTheaterId(theaterId);
    }

    @Override
    public List<Showtime> getShowtimesByMovieId(Long movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }

}
