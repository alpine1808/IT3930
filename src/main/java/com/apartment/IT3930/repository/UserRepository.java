package com.apartment.IT3930.repository;

import com.apartment.IT3930.model.user.UserAbstract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserAbstract, Long> {
    Optional<UserAbstract> findByEmail(String email);
}
