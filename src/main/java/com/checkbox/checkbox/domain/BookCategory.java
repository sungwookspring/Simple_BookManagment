package com.checkbox.checkbox.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "BOOK_CATEGORY")
public class BookCategory {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;
}
