package com.IT3930.apartment.controller;

import com.IT3930.apartment.dto.ApartmentDTO;
import com.IT3930.apartment.security.CustomUserDetails;
import com.IT3930.apartment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/apartments")
    public ResponseEntity<?> getMyApartments(@AuthenticationPrincipal CustomUserDetails userDetails) {
        try {
            Long ownerId = userDetails.getAccount().getId();
            List<ApartmentDTO> apartments = accountService.getApartmentsByOwner(ownerId)
                    .stream()
                    .map(ApartmentDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(apartments);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
