package com.apartment.IT3930.controller;

import com.apartment.IT3930.model.resident.Resident;
import com.apartment.IT3930.service.ResidentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @GetMapping
    public List<Resident> getAllResidents() {
        return residentService.getAllResidents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resident> getResidentById(@PathVariable Long id) {
        return residentService.getResidentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Resident createResident(@RequestBody Resident resident) {
        return residentService.saveResident(resident);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resident> updateResident(@PathVariable Long id, @RequestBody Resident residentDetails) {
        return residentService.getResidentById(id)
                .map(resident -> {
                    resident.setIdCardNumber(residentDetails.getIdCardNumber());
                    resident.setFullName(residentDetails.getFullName());
                    resident.setDateOfBirth(residentDetails.getDateOfBirth());
                    resident.setGender(residentDetails.getGender());
                    resident.setHometown(residentDetails.getHometown());
                    resident.setApartment(residentDetails.getApartment());
                    return ResponseEntity.ok(residentService.saveResident(resident));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResident(@PathVariable Long id) {
        return residentService.getResidentById(id)
                .map(resident -> {
                    residentService.deleteResident(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
