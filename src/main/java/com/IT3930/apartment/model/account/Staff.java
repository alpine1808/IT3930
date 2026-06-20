package com.IT3930.apartment.model.account;
import com.IT3930.apartment.model.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "staff")
@PrimaryKeyJoinColumn(name = "account_id")
public class Staff extends Account {
    public Staff() {
        setRole(Role.STAFF);
    }
    public Staff(String email, String password, String phone, boolean isActive) {
        super(email, password, phone, isActive);
        setRole(Role.STAFF);
    }
}
