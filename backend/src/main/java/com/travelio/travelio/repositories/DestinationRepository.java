package com.travelio.travelio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelio.travelio.models.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Integer> {
    Optional<Destination> findByCityAndCountry(String city, String country);

    Optional<List<Destination>> findByCountry(String country);
}
