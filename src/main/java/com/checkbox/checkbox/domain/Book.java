package com.checkbox.checkbox.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long id;

    private String title;

    private String author;

    @Builder
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
