package com.intern.book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name ="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String mainTitle;
    private String subtitle;
    private String author;
    private String publisher;
    private long  publisherYear;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "booktypes_id")
    private BookTypes bookTypes;
}
