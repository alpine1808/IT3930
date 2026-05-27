package com.apartment.IT3930.service;

import com.apartment.IT3930.model.resident.Resident;
import com.apartment.IT3930.repository.ResidentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ResidentService {

    private final ResidentRepository residentRepository;

    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    public List<Resident> getAllResidents() {
        return residentRepository.findAll();
    }

    public Optional<Resident> getResidentById(Long id) {
        return residentRepository.findById(id);
    }

    public Optional<Resident> getResidentByIdCardNumber(String idCardNumber) {
        return residentRepository.findByIdCardNumber(idCardNumber);
    }

    @Transactional
    public Resident saveResident(Resident resident) {
        return residentRepository.save(resident);
    }

    @Transactional
    public void deleteResident(Long id) {
        residentRepository.deleteById(id);
    }
}
