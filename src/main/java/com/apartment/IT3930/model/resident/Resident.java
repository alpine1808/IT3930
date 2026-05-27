package com.apartment.IT3930.model.resident;

import com.apartment.IT3930.model.apartment.Apartment;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "residents")
public class Resident implements ResidentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String idCardNumber; // CCCD

    @Column(nullable = false)
    private String fullName;

    private LocalDate dateOfBirth;

    private String gender;

    private String hometown;

    @ManyToOne
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    public Resident() {}

    public Resident(String idCardNumber, String fullName, LocalDate dateOfBirth, String gender, String hometown) {
        this.idCardNumber = idCardNumber;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.hometown = hometown;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getIdCardNumber() { return idCardNumber; }
    public void setIdCardNumber(String idCardNumber) { this.idCardNumber = idCardNumber; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getHometown() { return hometown; }
    public void setHometown(String hometown) { this.hometown = hometown; }
    public Apartment getApartment() { return apartment; }
    public void setApartment(Apartment apartment) { this.apartment = apartment; }
}
