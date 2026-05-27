package com.apartment.IT3930.model.user;

import com.apartment.IT3930.model.role.Role;
import com.apartment.IT3930.model.role.RoleName;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
@DiscriminatorValue("1")
public class Admin extends UserAbstract {
    public Admin() {
        super();
    }

    public Admin(String email, String displayName, String password) {
        super(email, displayName, password);
        this.addRole(new Role(RoleName.ADMIN));
    }
}
