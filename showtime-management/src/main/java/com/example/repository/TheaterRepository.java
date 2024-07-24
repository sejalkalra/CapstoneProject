package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long>{

}
