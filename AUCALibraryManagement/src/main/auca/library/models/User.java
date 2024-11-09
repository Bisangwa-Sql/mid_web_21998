package com.auca.library.models;

import com.auca.library.enums.Role;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId", columnDefinition = "BINARY(16)")
    private UUID userId;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personId", referencedColumnName = "personId")
    private Person person;

    public User() {}

    public User(UUID userId, String password, Role role, Person person) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.person = person;
    }

    // Getters and Setters
}
