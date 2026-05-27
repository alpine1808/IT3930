package com.apartment.IT3930.model.user;
import com.apartment.IT3930.model.role.Role;
import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
public abstract class UserAbstract implements UserInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String displayName;

    @Column(nullable = false, length = 60)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private final Set<Role> roles = new HashSet<>();

    @Override
    public Set<Role> getUserRole() {
        return this.roles;
    }

    @Override
    public String getUserEmail(){
        return this.email;
    }

    @Override
    public String getUserDisplayName(){
        return this.displayName;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected UserAbstract() {
        super();
    }

    public UserAbstract(String email, String displayName, String password) {
        this.email = email;
        this.displayName = displayName;
        this.password = password;
    }
}
