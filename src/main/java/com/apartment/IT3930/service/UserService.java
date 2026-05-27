package com.apartment.IT3930.service;

import com.apartment.IT3930.model.role.Role;
import com.apartment.IT3930.model.role.RoleName;
import com.apartment.IT3930.model.user.UserAbstract;
import com.apartment.IT3930.repository.RoleRepository;
import com.apartment.IT3930.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UserAbstract registerUser(UserAbstract user, RoleName roleName) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Find and add the role
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.addRole(role);

        return userRepository.save(user);
    }

    public List<UserAbstract> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserAbstract> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<UserAbstract> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void assignRoleToUser(String email, RoleName roleName) {
        UserAbstract user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Error: User not found."));
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        user.addRole(role);
        userRepository.save(user);
    }
}
