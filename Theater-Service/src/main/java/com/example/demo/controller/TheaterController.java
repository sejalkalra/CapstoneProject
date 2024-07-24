package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.demo.entity.Theater;
import com.example.demo.service.ITheaterService;

@RestController
@RequestMapping("/api/theaters")
public class TheaterController {

	@Autowired
    private ITheaterService theaterService;
	
	
    //http://localhost:9100/api/theaters/alltheater
    @GetMapping("/alltheater")
    public List<Theater> getAllTheaters() {
        return theaterService.findAll();
    }
    
    //http://localhost:9100/api/theaters/theater/1
    @GetMapping("/theater/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id) {
        Optional<Theater> theater = theaterService.findById(id);
        return theater.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    //http://localhost:9100/api/theaters/addtheater
    @PostMapping("/addtheater")
    public Theater createTheater(@RequestBody Theater theater) {
        return theaterService.save(theater);
    }

    //http://localhost:9100/api/theaters/edittheater/1
    @PutMapping("/edittheater/{id}")
    public ResponseEntity<Theater> updateTheater(@PathVariable Long id, @RequestBody Theater theaterDetails) {
        Optional<Theater> theater = theaterService.findById(id);
        if (theater.isPresent()) {
            Theater existingTheater = theater.get();
            existingTheater.setName(theaterDetails.getName());
            existingTheater.setLocation(theaterDetails.getLocation());
            existingTheater.setCapacity(theaterDetails.getCapacity());
            return ResponseEntity.ok(theaterService.save(existingTheater));
        }
        return ResponseEntity.notFound().build();
    }
    
    //http://localhost:9100/api/theaters/deletetheater/1
    @DeleteMapping("/deletetheater/{id}")
    public ResponseEntity<Void> deleteTheater(@PathVariable Long id) {
        theaterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
