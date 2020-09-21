package com.checkbox.checkbox.domain.Dto.Book;

import com.checkbox.checkbox.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BookResponseListallDto {
    private Long id;
    private String title;
    private String author;
    private List<BookGetCategoriesSubDto> bookCategories;
    private boolean readed;

    @Builder
    public BookResponseListallDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.bookCategories = entity.getBookCategories().stream()
            .map(bookCategory -> new BookGetCategoriesSubDto(bookCategory))
            .collect(Collectors.toList());
        this.readed = entity.isReaded();
    }
}
