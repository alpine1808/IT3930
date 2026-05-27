package com.apartment.IT3930.model.user;

import com.apartment.IT3930.model.role.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "staffs")
@DiscriminatorValue("3")
public class Staff extends UserAbstract {
    public Staff() {
        super();
    }

    public Staff(String email, String displayName, String password) {
        super(email, displayName, password);
        this.addRole(new Role(UserRole.STAFF));
    }
}
