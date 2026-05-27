package com.apartment.IT3930.model.user;
import java.util.Set;

public interface UserInterface {
    public String getUserEmail();
    public String getUserDisplayName();
    public Set<UserRole> getUserRole();
}
