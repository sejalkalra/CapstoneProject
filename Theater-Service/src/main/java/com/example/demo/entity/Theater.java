package com.example.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "theater")
public class Theater {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long theaterId;

	    private String name;
	    private String location;
	    private int capacity;

	    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL, orphanRemoval = true)
	    @JsonManagedReference
	    private List<Showtime> showtime;

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

		public List<Showtime> getShowtime() {
			return showtime;
		}

		public void setShowtime(List<Showtime> showtime) {
			this.showtime = showtime;
		}


		public Theater(String name, String location, int capacity, List<Showtime> showtime) {
			super();
			this.name = name;
			this.location = location;
			this.capacity = capacity;
			this.showtime = showtime;
		}

		public Theater() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
