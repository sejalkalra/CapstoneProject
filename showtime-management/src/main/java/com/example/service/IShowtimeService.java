package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.entity.Showtime;

public interface IShowtimeService {

   // Showtime createShowtime(Showtime showtime);

    Showtime updateShowtime(Long id, Showtime showtime);

   // void deleteShowtime(Integer id);

    //Optional<Showtime> getShowtimeById(Integer id);

    List<Showtime> getShowtimesByTheaterId(Long theaterId);

    List<Showtime> getShowtimesByMovieId(Long movieId);

	//List<Showtime> findAll();
    List<Showtime> getAllShowtimes();
    Optional<Showtime> getShowtimeById(Long id);
    Showtime saveShowtime(Showtime showtime);
    void deleteShowtime(Long id);

}
