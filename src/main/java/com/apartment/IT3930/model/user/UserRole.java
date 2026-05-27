package com.apartment.IT3930.model.user;

public enum UserRole {
    ADMIN(1),
    USER(2),
    STAFF(3);

    private final int value;
    UserRole(int value) { this.value = value; }

    public int getValue() { return value; }

    public static UserRole fromInt(int value) {
        for (UserRole role : UserRole.values()) {
            if (role.value == value) return role;
        }
        return null;
    }
}
