package com.travelio.travelio.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.travelio.travelio.models.Destination;
import com.travelio.travelio.requests.DestinationAddRequest;
import com.travelio.travelio.responses.DestinationAddResponse;
import com.travelio.travelio.services.DestinationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/destination")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @PostMapping("/add")
    public ResponseEntity<DestinationAddResponse> createDestination(@RequestBody DestinationAddRequest request) {
        try {
            DestinationAddResponse response = destinationService.createDestination(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    new DestinationAddResponse("An error occurred while creating the destination"));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Destination> getDestinationById(@PathVariable Integer id) {
        Optional<Destination> destination = destinationService.getDestinationById(id);
        if (destination.isPresent()) {
            return ResponseEntity.ok(destination.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Destination>> getAllDestinations() {
        List<Destination> destinations = destinationService.getAllDestinations();
        if (destinations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(destinations);
    }

    @GetMapping("/getByCountry/{country}")
    public ResponseEntity<List<String>> getCitiesByCountry(@PathVariable String country) {
        List<String> cities = destinationService.getCitiesByCountry(country);
        if (!cities.isEmpty()) {
            return ResponseEntity.ok(cities);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Integer id) {
        destinationService.deleteDestination(id);
        return ResponseEntity.ok().build();
    }
}
