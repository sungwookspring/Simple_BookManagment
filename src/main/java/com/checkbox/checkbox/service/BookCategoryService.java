package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.BookCategory;
import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.BookCategory.BookCategoryRequestAddDto;
import com.checkbox.checkbox.repository.BookCategoryRepository;
import com.checkbox.checkbox.repository.BookRepository;
import com.checkbox.checkbox.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(BookCategoryRequestAddDto requestAddDto){
        Book findBook = bookRepository.findById(requestAddDto.getBook_id())
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 book_id")
                );

        Category findCategory = categoryRepository.findById(requestAddDto.getCategory_id())
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 category_id")
                );


        // 카테코리 연결
        BookCategory new_bookcategory = BookCategory.builder()
                .category(findCategory)
                .build();

        // 책 연결
        findBook.setRelationWithBookCategory(new_bookcategory);

        return bookCategoryRepository.save(new_bookcategory).getId();
    }

    public List<BookCategory> findAll(){
        return bookCategoryRepository.findAll();
    }
}
