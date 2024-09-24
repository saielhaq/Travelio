package com.travelio.travelio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelio.travelio.requests.AuthenticationRequest;
import com.travelio.travelio.requests.RegisterRequest;
import com.travelio.travelio.responses.AddUserResponse;
import com.travelio.travelio.responses.AuthenticationResponse;
import com.travelio.travelio.services.AuthenticationService;
import com.travelio.travelio.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerMethod(@RequestBody RegisterRequest registerRequest) {
        if (userService.getUserByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(new AddUserResponse("User already exists"));
        }
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }

}
