package com.example.service;

import com.example.entity.Booking;
import com.example.entity.Showtime;
import com.example.entity.User;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.BookingRepository;
import com.example.repository.ShowtimeRepository;
import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    UserRepository userRepo;
    @Autowired
    ShowtimeRepository showRepo;

    public Booking createBooking(Booking booking) {
    	User user = userRepo.findById(booking.getUserId()).get();
    	Showtime show = showRepo.findById(booking.getShowtimeId()).get();
    	booking.setUser(user);
    	booking.setShowtime(show);
        return bookingRepository.save(booking);
    }

    public Optional<Booking> getBookingById(Long bookingId) {
        return Optional.of(bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId)));
    }
 
    public List<Booking> getAllBookingsForUser(Long userId) {
    	
        return bookingRepository.findByUserId(userId);
    }

    public Booking updateBooking(Long bookingId, Booking bookingDetails) {
        return bookingRepository.findById(bookingId).map(booking -> {
            booking.setNumberOfTickets(bookingDetails.getNumberOfTickets());
            booking.setTotalPrice(bookingDetails.getTotalPrice());
            return bookingRepository.save(booking);
        }).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));
    }

    public void deleteBooking(Long bookingId) {
        if (!bookingRepository.existsById(bookingId)) {
            throw new ResourceNotFoundException("Booking not found with id: " + bookingId);
        }
        bookingRepository.deleteById(bookingId);
    }
}
