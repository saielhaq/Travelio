package com.travelio.travelio.services;

import com.travelio.travelio.requests.AuthenticationRequest;
import com.travelio.travelio.requests.RegisterRequest;
import com.travelio.travelio.responses.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

}
