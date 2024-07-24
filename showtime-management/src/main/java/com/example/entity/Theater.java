package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theater")

public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_id")
    private Long theaterId;

    @Column(nullable = false)
    private String name;

    private String location;

    private int capacity;

    // One-to-Many relationship with Showtime
    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Showtime> showtimes;

	public Long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(List<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

	public Theater(Long theaterId, String name, String location, int capacity, List<Showtime> showtimes) {
		super();
		this.theaterId = theaterId;
		this.name = name;
		this.location = location;
		this.capacity = capacity;
		this.showtimes = showtimes;
	}

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}

