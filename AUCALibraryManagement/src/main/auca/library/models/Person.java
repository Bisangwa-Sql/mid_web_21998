package com.auca.library.models;

import com.auca.library.enums.Gender;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "personId", columnDefinition = "BINARY(16)")
    private UUID personId;

    private String firstName;

    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String phoneNumber;

    public Person() {}

    public Person(UUID personId, String firstName, String lastName, Gender gender, String phoneNumber) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
}
