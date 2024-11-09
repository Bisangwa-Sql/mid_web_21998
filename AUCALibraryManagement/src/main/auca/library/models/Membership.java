package com.auca.library.models;

import com.auca.library.enums.MembershipStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "memberships")
public class Membership {

    @Id
    @GeneratedValue
    @Column(name = "membershipId", columnDefinition = "BINARY(16)")
    private UUID membershipId;

    private String startDate;

    private String expiryDate;

    private int membershipTypeId;

    @Enumerated(EnumType.STRING)
    private MembershipStatus membershipStatus;

    public Membership() {}

    public Membership(UUID membershipId, String startDate, String expiryDate, int membershipTypeId, MembershipStatus membershipStatus) {
        this.membershipId = membershipId;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.membershipTypeId = membershipTypeId;
        this.membershipStatus = membershipStatus;
    }

    // Getters and Setters
}
