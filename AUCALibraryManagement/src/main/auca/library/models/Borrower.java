package com.auca.library.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "borrowers")
public class Borrower {

    @Id
    @GeneratedValue
    @Column(name = "borrowerId", columnDefinition = "BINARY(16)")
    private UUID borrowerId;

    @Column(name = "bookId", columnDefinition = "BINARY(16)")
    private UUID bookId;

    @Column(name = "readerId", columnDefinition = "BINARY(16)")
    private UUID readerId;

    private String dueDate;

    private String returnDate;

    private double chargeFees;

    public Borrower() {}

    public Borrower(UUID borrowerId, UUID bookId, UUID readerId, String dueDate, String returnDate, double chargeFees) {
        this.borrowerId = borrowerId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.chargeFees = chargeFees;
    }

    // Getters and Setters
}
