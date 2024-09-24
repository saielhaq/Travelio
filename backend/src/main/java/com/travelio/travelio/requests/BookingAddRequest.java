package com.travelio.travelio.requests;

import java.util.Date;

import com.travelio.travelio.models.Status;

public class BookingAddRequest {
    private String destination;
    private Date onGoing;
    private Date returnDate;
    private Status status;
    private Integer userId;

    public BookingAddRequest() {
    }

    public BookingAddRequest(String destination, Date onGoing, Date returnDate, Status status, Integer userId) {
        this.destination = destination;
        this.onGoing = onGoing;
        this.returnDate = returnDate;
        this.status = status;
        this.userId = userId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getOnGoing() {
        return onGoing;
    }

    public void setOnGoing(Date onGoing) {
        this.onGoing = onGoing;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
