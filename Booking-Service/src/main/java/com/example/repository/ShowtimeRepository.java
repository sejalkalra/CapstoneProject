package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long>{
}
