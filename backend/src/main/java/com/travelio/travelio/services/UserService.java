package com.travelio.travelio.services;

import java.util.List;
import java.util.Optional;

import com.travelio.travelio.models.User;
import com.travelio.travelio.requests.RegisterRequest;
import com.travelio.travelio.responses.AddUserResponse;

public interface UserService {
    Optional<User> getUserById(Integer id);

    List<User> getAllUsers();

    AddUserResponse createUser(RegisterRequest request);

    Optional<User> getUserByEmail(String email);

    void deleteUser(Integer id);
}
