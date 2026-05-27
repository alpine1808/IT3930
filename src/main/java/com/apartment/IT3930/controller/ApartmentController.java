package com.apartment.IT3930.controller;

import com.apartment.IT3930.model.apartment.Apartment;
import com.apartment.IT3930.service.ApartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apartment> getApartmentById(@PathVariable Long id) {
        return apartmentService.getApartmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Apartment createApartment(@RequestBody Apartment apartment) {
        return apartmentService.saveApartment(apartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Apartment> updateApartment(@PathVariable Long id, @RequestBody Apartment apartmentDetails) {
        return apartmentService.getApartmentById(id)
                .map(apartment -> {
                    apartment.setName(apartmentDetails.getName());
                    apartment.setArea(apartmentDetails.getArea());
                    apartment.setOwner(apartmentDetails.getOwner());
                    return ResponseEntity.ok(apartmentService.saveApartment(apartment));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApartment(@PathVariable Long id) {
        return apartmentService.getApartmentById(id)
                .map(apartment -> {
                    apartmentService.deleteApartment(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
