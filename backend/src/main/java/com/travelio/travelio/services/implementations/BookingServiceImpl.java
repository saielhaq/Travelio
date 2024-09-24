package com.travelio.travelio.services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelio.travelio.models.Booking;
import com.travelio.travelio.models.Status;
import com.travelio.travelio.models.User;
import com.travelio.travelio.repositories.BookingRepository;
import com.travelio.travelio.repositories.UserRepository;
import com.travelio.travelio.requests.BookingAddRequest;
import com.travelio.travelio.responses.BookingAddResponse;
import com.travelio.travelio.services.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public BookingAddResponse addBooking(BookingAddRequest bookingAddRequest) {
        Booking booking = new Booking();
        Optional<User> user = userRepository.findById(bookingAddRequest.getUserId());
        if (user.isPresent()) {
            booking.setDestination(bookingAddRequest.getDestination());
            booking.setOnGoing(bookingAddRequest.getOnGoing());
            booking.setReturnDate(bookingAddRequest.getReturnDate());
            booking.setStatus(Status.PENDING);
            booking.setUser(user.get());
            bookingRepository.save(booking);
            return new BookingAddResponse("Booking added successfully");
        } else {
            return new BookingAddResponse("User not found");
        }
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Integer bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    @Override
    public List<Booking> getBookingsByUserId(Integer userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public Booking approveBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(Status.APPROVED);
        return bookingRepository.save(booking);

    }

    @Override
    public Booking rejectBooking(Integer bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(Status.REJECTED);
        return bookingRepository.save(booking);
    }

}
