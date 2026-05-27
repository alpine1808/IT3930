package com.apartment.IT3930.repository;

import com.apartment.IT3930.model.resident.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Optional<Resident> findByIdCardNumber(String idCardNumber);
}
