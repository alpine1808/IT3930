package com.IT3930.apartment.controller;

import com.IT3930.apartment.dto.AccountCreateDTO;
import com.IT3930.apartment.dto.AccountResponseDTO;
import com.IT3930.apartment.dto.AccountAdminUpdateDTO;
import com.IT3930.apartment.dto.ApartmentDTO;
import com.IT3930.apartment.dto.AssignApartmentsRequestDTO;
import com.IT3930.apartment.model.account.Account;
import com.IT3930.apartment.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AccountService accountService;

    // Only admins should access this, which can be protected by Spring Security
    // e.g. @PreAuthorize("hasRole('ADMIN')") or via SecurityConfig matchers
    @PostMapping("/accounts")
    public ResponseEntity<?> createAccount(@RequestBody AccountCreateDTO createDTO) {
        try {
            Account newAccount = accountService.createAccount(
                    createDTO.getEmail(),
                    createDTO.getPassword(),
                    createDTO.getPhone(),
                    createDTO.getRole()
            );
            return ResponseEntity.ok(new AccountResponseDTO(newAccount));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/accounts")
    public ResponseEntity<?> getAllAccounts() {
        try {
            List<AccountResponseDTO> accounts = accountService.getAllAccounts()
                    .stream()
                    .map(AccountResponseDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(accounts);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity<?> updateAccount(
            @PathVariable Long id,
            @RequestBody AccountAdminUpdateDTO updateDTO) {
        try {
            Account updatedAccount = accountService.updateAccountByAdmin(
                    id,
                    updateDTO.getEmail(),
                    updateDTO.getPassword(),
                    updateDTO.getPhone(),
                    updateDTO.getIsActive()
            );
            return ResponseEntity.ok(new AccountResponseDTO(updatedAccount));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable Long id) {
        try {
            accountService.deleteAccount(id);
            return ResponseEntity.ok("Account deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/apartments/available")
    public ResponseEntity<?> getAvailableApartments() {
        try {
            List<ApartmentDTO> apartments = accountService.getAvailableApartments()
                    .stream()
                    .map(ApartmentDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(apartments);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/accounts/{id}/apartments")
    public ResponseEntity<?> getApartmentsByOwner(@PathVariable Long id) {
        try {
            List<ApartmentDTO> apartments = accountService.getApartmentsByOwner(id)
                    .stream()
                    .map(ApartmentDTO::new)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(apartments);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/accounts/{id}/apartments")
    public ResponseEntity<?> assignApartments(
            @PathVariable Long id,
            @RequestBody AssignApartmentsRequestDTO request) {
        try {
            accountService.assignApartmentsToOwner(id, request.getApartmentIds());
            return ResponseEntity.ok("Apartments assigned successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
