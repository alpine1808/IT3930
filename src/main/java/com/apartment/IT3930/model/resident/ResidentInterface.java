package com.apartment.IT3930.model.resident;

import com.apartment.IT3930.model.apartment.Apartment;
import java.time.LocalDate;

public interface ResidentInterface {
    public String getIdCardNumber();
    public String getFullName();
    public LocalDate getDateOfBirth();
    public String getGender();
    public String getHometown();
    public Apartment getApartment();
}
