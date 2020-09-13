package com.checkbox.checkbox.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "BOOK_CATEGORY")
@NoArgsConstructor
public class BookCategory {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_category_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public BookCategory(Category category){
        this.category = category;
    }
}
