package com.checkbox.checkbox.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    private boolean readed;

    @OneToMany(mappedBy = "book")
    private List<BookCategory> bookCategories;

    /***
     * 비지니스 로직: 수정
     */
    public void update(String title, String author, boolean readed){
        this.title = title;
        this.author = author;
        this.readed = readed;
    }
    
    @Builder
    public Book(String title, String author, boolean readed) {
        this.title = title;
        this.author = author;
        this.readed = readed;
    }
}
