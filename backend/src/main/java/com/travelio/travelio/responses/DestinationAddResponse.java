package com.travelio.travelio.responses;

public class DestinationAddResponse {
    private String message;

    public DestinationAddResponse() {
    }

    public DestinationAddResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
