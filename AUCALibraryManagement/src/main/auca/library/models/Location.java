package com.auca.library.models;

import com.auca.library.enums.LocationType;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    @Column(name = "locationId", columnDefinition = "BINARY(16)")
    private UUID locationId;

    private String locationCode;

    private String locationName;

    @Enumerated(EnumType.STRING)
    private LocationType locationType;

    public Location() {}

    public Location(UUID locationId, String locationCode, String locationName, LocationType locationType) {
        this.locationId = locationId;
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.locationType = locationType;
    }

    // Getters and Setters
}
