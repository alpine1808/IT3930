package com.apartment.IT3930.model.role;

import com.apartment.IT3930.model.user.UserRole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements RoleInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private UserRole name;

    public Role() {}

    public Role(UserRole name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public UserRole getName() {
        return name;
    }

    public void setName(UserRole name) {
        this.name = name;
    }
}
