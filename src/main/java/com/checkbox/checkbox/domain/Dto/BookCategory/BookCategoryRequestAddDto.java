package com.checkbox.checkbox.domain.Dto.BookCategory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCategoryRequestAddDto {
    private Long book_id;
    private Long category_id;
}
