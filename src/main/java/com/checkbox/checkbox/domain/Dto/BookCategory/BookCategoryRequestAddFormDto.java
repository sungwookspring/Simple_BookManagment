package com.checkbox.checkbox.domain.Dto.BookCategory;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookCategoryRequestAddFormDto {
    private List<RequestAddForm_BookDto> books = new ArrayList<>();
    private List<RequestAddForm_CategoryDto> categories = new ArrayList<>();

    public void addBook(RequestAddForm_BookDto bookDto){
        this.books.add(bookDto);
    }

    public void addCategory(RequestAddForm_CategoryDto categoryDto){
        this.categories.add(categoryDto);
    }

    @Builder
    public BookCategoryRequestAddFormDto(List<RequestAddForm_BookDto> books, List<RequestAddForm_CategoryDto> categories){
        this.categories = categories;
        this.books = books;
    }
}
