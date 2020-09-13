package com.checkbox.checkbox.domain.Dto.Book;

import com.checkbox.checkbox.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookResponseListallDto {
    private Long id;
    private String title;
    private String author;
    private boolean readed;

    @Builder
    public BookResponseListallDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.readed = entity.isReaded();
    }
}
