package com.travelio.travelio.services.implementations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelio.travelio.models.Destination;
import com.travelio.travelio.repositories.DestinationRepository;
import com.travelio.travelio.requests.DestinationAddRequest;
import com.travelio.travelio.responses.DestinationAddResponse;
import com.travelio.travelio.services.DestinationService;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Optional<Destination> getDestinationById(Integer id) {
        return destinationRepository.findById(id);
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public DestinationAddResponse createDestination(DestinationAddRequest request) {
        var destination = new Destination();
        destination.setCity(request.getCity());
        destination.setCountry(request.getCountry());
        destinationRepository.save(destination);
        return new DestinationAddResponse("Destination created successfully");
    }

    @Override
    public void deleteDestination(Integer id) {
        destinationRepository.deleteById(id);
    }

    @Override
    public Optional<List<Destination>> getDestinationsByCountry(String country) {
        return destinationRepository.findByCountry(country);
    }

    @Override
    public List<String> getCitiesByCountry(String country) {
        return destinationRepository.findByCountry(country)
                .orElse(Collections.emptyList())
                .stream()
                .map(Destination::getCity)
                .collect(Collectors.toList());
    }
}
