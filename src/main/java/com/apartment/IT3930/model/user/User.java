package com.apartment.IT3930.model.user;

import com.apartment.IT3930.model.apartment.Apartment;
import com.apartment.IT3930.model.role.Role;
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
        this.addRole(new Role(UserRole.USER));
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
}
