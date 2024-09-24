package com.travelio.travelio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.travelio.travelio.models.Destination;
import com.travelio.travelio.requests.DestinationAddRequest;
import com.travelio.travelio.responses.DestinationAddResponse;

@Service
public interface DestinationService {

    public Optional<Destination> getDestinationById(Integer id);

    public List<Destination> getAllDestinations();

    public List<String> getCitiesByCountry(String country);

    public DestinationAddResponse createDestination(DestinationAddRequest request);

    public void deleteDestination(Integer id);

    public Optional<List<Destination>> getDestinationsByCountry(String country);
}
