package com.apartment.IT3930.repository;

import com.apartment.IT3930.model.role.Role;
import com.apartment.IT3930.model.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
