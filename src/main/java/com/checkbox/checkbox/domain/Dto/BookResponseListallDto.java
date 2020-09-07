package com.checkbox.checkbox.domain.Dto;

import com.checkbox.checkbox.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookResponseListallDto {
    private String title;
    private String author;

    @Builder
    public BookResponseListallDto(Book entity) {
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
    }
}
