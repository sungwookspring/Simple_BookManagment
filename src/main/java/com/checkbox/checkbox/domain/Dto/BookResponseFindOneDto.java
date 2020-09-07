package com.checkbox.checkbox.domain.Dto;

import com.checkbox.checkbox.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BookResponseFindOneDto {
    private Long id;
    private String title;
    private String author;
    private boolean readed;

    @Builder
    public BookResponseFindOneDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.readed = entity.isReaded();
    }
}
