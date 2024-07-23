package com.example.controler;

import com.example.entity.Booking;
import com.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    //http://localhost:9100/api/bookings
    @PostMapping(value = "/endpoint", consumes = "application/json", produces = "application/json")
         public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    //http://localhost:9100/api/bookings/1
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long bookingId) {
        Optional<Booking> booking = bookingService.getBookingById(bookingId);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    //http://localhost:9100/api/user/1
    @GetMapping("/user/{userId}")
    public List<Booking> getAllBookingsForUser(@PathVariable Long userId) {
        return bookingService.getAllBookingsForUser(userId);
    }
    
    //http://localhost:9100/api/2
    @PutMapping("/{bookingId}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long bookingId, @RequestBody Booking bookingDetails) {
        return ResponseEntity.ok(bookingService.updateBooking(bookingId, bookingDetails));
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok().build();
    }
}
