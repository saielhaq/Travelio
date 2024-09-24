package com.travelio.travelio.services;

import java.util.List;

import com.travelio.travelio.models.Booking;
import com.travelio.travelio.requests.BookingAddRequest;
import com.travelio.travelio.responses.BookingAddResponse;

public interface BookingService {

    public BookingAddResponse addBooking(BookingAddRequest bookingAddRequest);

    public List<Booking> getAllBookings();

    public Booking getBookingById(Integer bookingId);

    public List<Booking> getBookingsByUserId(Integer userId);

    public Booking approveBooking(Integer bookingId);

    public Booking rejectBooking(Integer bookingId);
}
