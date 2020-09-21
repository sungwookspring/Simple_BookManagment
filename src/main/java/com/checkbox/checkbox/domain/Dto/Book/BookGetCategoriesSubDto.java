package com.checkbox.checkbox.domain.Dto.Book;

import com.checkbox.checkbox.domain.BookCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookGetCategoriesSubDto {
    private Long bookcategory_id;
    private String category_name;

    @Builder
    public BookGetCategoriesSubDto(BookCategory bookCategory) {
        this.bookcategory_id = bookCategory.getId();
        this.category_name = bookCategory.getCategory().getName();
    }
}
