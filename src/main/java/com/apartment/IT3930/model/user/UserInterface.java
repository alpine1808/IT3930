package com.apartment.IT3930.model.user;
import com.apartment.IT3930.model.role.Role;
import java.util.Set;

public interface UserInterface {
    public String getUserEmail();
    public String getUserDisplayName();
    public Set<Role> getUserRole();
}
