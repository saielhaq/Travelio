package com.travelio.travelio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.travelio.travelio.models.Role;
import com.travelio.travelio.models.User;
import com.travelio.travelio.repositories.UserRepository;

@SpringBootApplication
public class TravelioApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(TravelioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(
				new User("Saad Sai El Haq", "saielhaqs@gmail.com", passwordEncoder.encode("password"), Role.ADMIN));
	}

}
