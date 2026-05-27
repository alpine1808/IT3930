package com.apartment.IT3930.model.user;

import com.apartment.IT3930.model.apartment.Apartment;
import com.apartment.IT3930.model.role.Role;
import com.apartment.IT3930.model.role.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name = "resident_users")
@DiscriminatorValue("2")
public class User extends UserAbstract {

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Apartment apartment;

    public User() {
        super();
    }

    public User(String email, String displayName, String password) {
        super(email, displayName, password);
        this.addRole(new Role(RoleName.USER));
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    /**
     * Checks if the user has an apartment assigned.
     */
    public boolean hasApartment() {
        return this.apartment != null;
    }

    /**
     * Gets the total number of residents living in the user's apartment.
     */
    public int getResidentCount() {
        return hasApartment() ? this.apartment.getResidents().size() : 0;
    }

    /**
     * Gets the area of the apartment owned by this user.
     */
    public Double getApartmentArea() {
        return hasApartment() ? this.apartment.getArea() : 0.0;
    }

    /**
     * Helper to check if the apartment is "empty" (no residents registered).
     */
    public boolean isApartmentEmpty() {
        return hasApartment() && this.apartment.getResidents().isEmpty();
    }
}
