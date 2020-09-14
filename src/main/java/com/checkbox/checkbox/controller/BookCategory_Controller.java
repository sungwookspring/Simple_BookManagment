package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.BookCategory.BookCategoryRequestAddFormDto;
import com.checkbox.checkbox.domain.Dto.BookCategory.RequestAddForm_BookDto;
import com.checkbox.checkbox.domain.Dto.BookCategory.RequestAddForm_CategoryDto;
import com.checkbox.checkbox.service.BookCategoryService;
import com.checkbox.checkbox.service.BookService;
import com.checkbox.checkbox.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookCategory_Controller {
    private final CategoryService categoryService;
    private final BookService bookService;

    @GetMapping("/book/category_book/add")
    public String saveForm(Model model){
        List<Book> allBooks = bookService.findAll();

        // 모든 책
        List<RequestAddForm_BookDto> bookDtos = new ArrayList<>();
        allBooks.forEach(book -> bookDtos.add(
                RequestAddForm_BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .build()
        ));

        
        //모든 카테고리
        List<Category> allCategories = categoryService.findAll();
        List<RequestAddForm_CategoryDto> categoryDtos = new ArrayList<>();
        allCategories.forEach(category -> categoryDtos.add(
                RequestAddForm_CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build()
        ));

        // 뷰에게 전달
        BookCategoryRequestAddFormDto bookcategories = BookCategoryRequestAddFormDto.builder()
                .books(bookDtos)
                .categories(categoryDtos)
                .build();

        model.addAttribute("books", bookcategories);

        return "book_category/setRelation";
    }

    @PostMapping("/book/category/add")
    public String save(){
        return "book_category/setRelation";
    }
}
