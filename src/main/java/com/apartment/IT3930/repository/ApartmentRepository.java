package com.apartment.IT3930.repository;

import com.apartment.IT3930.model.apartment.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {
    Optional<Apartment> findByName(String name);
}
