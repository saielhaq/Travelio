package com.travelio.travelio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelio.travelio.models.Booking;
import com.travelio.travelio.models.Status;
import com.travelio.travelio.requests.BookingAddRequest;
import com.travelio.travelio.responses.BookingAddResponse;
import com.travelio.travelio.services.BookingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/add")
    public ResponseEntity<BookingAddResponse> addBooking(@RequestBody BookingAddRequest bookingAddRequest) {
        bookingService.addBooking(bookingAddRequest);
        return ResponseEntity.ok(new BookingAddResponse("Booking added successfully"));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/getByUserId/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Integer userId) {
        List<Booking> bookings = bookingService.getBookingsByUserId(userId);
        if (bookings.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bookings);
    }

    @PutMapping("/approve/{bookingId}")
    public ResponseEntity<Booking> approveBooking(@PathVariable Integer bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        if (booking.getStatus() != Status.PENDING) {
            return ResponseEntity.badRequest().build();
        }
        booking = bookingService.approveBooking(bookingId);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/reject/{bookingId}")
    public ResponseEntity<Booking> rejectBooking(@PathVariable Integer bookingId) {
        Booking booking = bookingService.getBookingById(bookingId);
        if (booking.getStatus() != Status.PENDING) {
            return ResponseEntity.badRequest().build();
        }
        booking = bookingService.rejectBooking(bookingId);
        return ResponseEntity.ok(booking);
    }
}
