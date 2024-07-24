package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import com.example.entity.Showtime;

import com.example.service.IShowtimeService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {
    @Autowired
    private IShowtimeService showtimeService;

    @GetMapping("/all")
    public List<Showtime> getAllShowtimes() {
        return showtimeService.getAllShowtimes();
    }

    @GetMapping("/getshow/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable Long id) {
        Optional<Showtime> showtime = showtimeService.getShowtimeById(id);
        return showtime.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addshow")
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeService.saveShowtime(showtime);
    }

    @PutMapping("/editshow/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable Long id, @RequestBody Showtime showtime) {
        Showtime updatedShowtime = showtimeService.updateShowtime(id, showtime);
        return ResponseEntity.ok(updatedShowtime);
    }

    @DeleteMapping("/deleteshow/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable Long id) {
        showtimeService.deleteShowtime(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Showtime>> getShowtimesByTheaterId(@PathVariable Long theaterId) {
        List<Showtime> showtimes = showtimeService.getShowtimesByTheaterId(theaterId);
        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowtimesByMovieId(@PathVariable Long movieId) {
        List<Showtime> showtimes = showtimeService.getShowtimesByMovieId(movieId);
        return ResponseEntity.ok(showtimes);
    }
}

