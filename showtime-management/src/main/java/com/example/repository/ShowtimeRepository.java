package com.example.repository;


import com.example.entity.Movie;
import com.example.entity.Showtime;
import com.example.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
	
	    List<Showtime> findByTheaterId(Long theaterId);

	    List<Showtime> findByMovieId(Long movie_id);
}
