package com.apartment.IT3930.model.apartment;

import com.apartment.IT3930.model.resident.Resident;
import com.apartment.IT3930.model.user.User;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "apartments")
public class Apartment implements ApartmentInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double area;

    @OneToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id", unique = true)
    private User owner;

    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resident> residents = new ArrayList<>();

    public Apartment() {}

    public Apartment(String name, Double area, User owner) {
        this.name = name;
        this.area = area;
        this.owner = owner;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void addResident(Resident resident) {
        residents.add(resident);
        resident.setApartment(this);
    }

    public void removeResident(Resident resident) {
        residents.remove(resident);
        resident.setApartment(null);
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
