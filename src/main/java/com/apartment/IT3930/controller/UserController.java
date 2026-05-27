package com.apartment.IT3930.controller;

import com.apartment.IT3930.model.role.RoleName;
import com.apartment.IT3930.model.user.UserAbstract;
import com.apartment.IT3930.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserAbstract> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAbstract> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public UserAbstract registerUser(@RequestBody UserAbstract user, @RequestParam RoleName role) {
        return userService.registerUser(user, role);
    }

    @PutMapping("/{email}/role")
    public ResponseEntity<Void> assignRole(@PathVariable String email, @RequestParam RoleName role) {
        userService.assignRoleToUser(email, role);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> {
                    userService.deleteUser(id);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
