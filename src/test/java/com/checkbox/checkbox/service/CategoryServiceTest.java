package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.BookCategory;
import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.Category.CategoryRequestAddDto;
import com.checkbox.checkbox.repository.BookCategoryRepository;
import com.checkbox.checkbox.repository.BookRepository;
import com.checkbox.checkbox.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    BookService bookService;
    @Autowired
    BookCategoryRepository bookCategoryRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookCategoryService bookCategoryService;

    @Test
    public void save(){
        //given
        CategoryRequestAddDto requestAddDto = new CategoryRequestAddDto();
        requestAddDto.setName("책");

        //when
        Long saveId = categoryService.save(requestAddDto);

        //then
        Category findCategory = categoryRepository.findById(saveId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 카테고리 ID")
                );

        Assertions.assertThat(findCategory.getName()).isEqualTo(requestAddDto.getName());

    }

    @Test
    @Transactional
    public void createBook_createCategory_AndDoRelation(){
        // 책 생성
        BookRequestAddDto bookdto = new BookRequestAddDto();
        bookdto.setAuthor("테스트 작가");
        bookdto.setTitle("테스트 책");
        Long savedBookId = bookService.save(bookdto);
        Book findBook = bookRepository.findById(savedBookId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 Book_id")
                );

        // 카테고리 생성
        CategoryRequestAddDto categorydto = new CategoryRequestAddDto();
        categorydto.setName("교양");
        Long saveCategoryId = categoryService.save(categorydto);

        // 책<>카테고리
        Category savedCategory = categoryRepository.findById(saveCategoryId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 카테고리 ID")
                );

        // when
        BookCategory bookCategory = BookCategory.builder()
                .category(savedCategory)
                .build();

        Long savedBookCategoryId = bookCategoryService.save(bookCategory);
        BookCategory findBookCategory = bookCategoryRepository.findById(savedBookCategoryId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 savedBookCategoryId")
                );

        findBook.setRelationWithBookCategory(findBookCategory);
    }

}