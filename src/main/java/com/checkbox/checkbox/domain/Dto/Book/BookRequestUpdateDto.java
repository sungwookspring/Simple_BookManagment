package com.checkbox.checkbox.domain.Dto.Book;

import com.checkbox.checkbox.domain.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestUpdateDto {
    private Long id;
    private String title;
    private String author;
    private boolean readed;
}
