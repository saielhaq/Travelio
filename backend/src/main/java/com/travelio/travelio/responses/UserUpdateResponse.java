package com.travelio.travelio.responses;

public class UserUpdateResponse {
    private String message;

    public UserUpdateResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
