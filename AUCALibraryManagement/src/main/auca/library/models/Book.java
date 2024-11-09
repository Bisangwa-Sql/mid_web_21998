package com.auca.library.models;

import com.auca.library.enums.BookStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    @Column(name = "bookId", columnDefinition = "BINARY(16)")
    private UUID bookId;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private int edition;

    @Column(nullable = true)
    private String isbnCode;

    @Column(nullable = true)
    private String publicationYear;

    public Book() {}

    public Book(UUID bookId, String title, BookStatus status, int edition, String isbnCode, String publicationYear) {
        this.bookId = bookId;
        this.title = title;
        this.status = status;
        this.edition = edition;
        this.isbnCode = isbnCode;
        this.publicationYear = publicationYear;
    }

    // Getters and Setters
}
