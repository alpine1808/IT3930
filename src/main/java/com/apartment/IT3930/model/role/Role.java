package com.apartment.IT3930.model.role;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements RoleInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true, length = 20)
    private RoleName name;

    public Role() {}

    public Role(RoleName name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
