package com.example.entity;

import java.util.List;

import com.example.entity.Booking;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long userId;
	    private String username;
	    private String password;
	    private String email;
	    private String role;
	    private String firstName;
	    private String lastName;
	    
	    @OneToMany(mappedBy = "user")
	   // @JsonManagedReference
	    private List<Booking> bookings;
	    
	    

	    public User() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	    
		public User(String username, String password, String email, String role, String firstName,
				String lastName, List<Booking> bookings) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.role = role;
			this.firstName = firstName;
			this.lastName = lastName;
			this.bookings = bookings;
		}



		public Long getUserId() {
	        return userId;
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public List<Booking> getBookings() {
	        return bookings;
	    }

	    public void setBookings(List<Booking> bookings) {
	        this.bookings = bookings;
	    }



	

    
}
