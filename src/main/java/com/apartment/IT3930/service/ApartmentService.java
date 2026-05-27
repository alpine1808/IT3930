package com.apartment.IT3930.service;

import com.apartment.IT3930.model.apartment.Apartment;
import com.apartment.IT3930.repository.ApartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ApartmentService {

    private final ApartmentRepository apartmentRepository;

    public ApartmentService(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    public Optional<Apartment> getApartmentById(Long id) {
        return apartmentRepository.findById(id);
    }

    public Optional<Apartment> getApartmentByName(String name) {
        return apartmentRepository.findByName(name);
    }

    @Transactional
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepository.save(apartment);
    }

    @Transactional
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);
    }
}
