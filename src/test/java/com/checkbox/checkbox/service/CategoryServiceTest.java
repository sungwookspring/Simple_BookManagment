package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.BookCategory;
import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.BookCategory.BookCategoryRequestAddDto;
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
        // given

        // 책 생성
        Book savedBook =  createbook_checkId("테스트 책", "테스트 작가");

        // 카테고리 생성
        Category savedCategory = createCategory_checkId("테스트 카테고리");

        // when
        BookCategoryRequestAddDto requestAddDto = new BookCategoryRequestAddDto();
        requestAddDto.setBook_id(savedBook.getId());
        requestAddDto.setCategory_id(savedCategory.getId());

        Long savedBookCategoryId = bookCategoryService.save(requestAddDto);

        //then
        BookCategory findBookCategory = bookCategoryRepository.findById(savedBookCategoryId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 savedBookCategoryId")
                );


        // Id 비교
        Long findCategoryId = findBookCategory.getCategory().getId();
        Long findBookId =  findBookCategory.getBook().getId();

        Assertions.assertThat(findCategoryId).isEqualTo(savedCategory.getId());
        Assertions.assertThat(findBookId).isEqualTo(savedBook.getId());

        // 이름 비교
        String findCategoryName = findBookCategory.getCategory().getName();
        String findBookName =  findBookCategory.getBook().getTitle();

        Assertions.assertThat(findCategoryName).isEqualTo(savedCategory.getName());
        Assertions.assertThat(findBookName).isEqualTo(savedBook.getTitle());
    }

    public Book createbook_checkId(String title, String author){
        BookRequestAddDto bookdto = new BookRequestAddDto();
        bookdto.setAuthor("title");
        bookdto.setTitle("author");
        Long savedBookId = bookService.save(bookdto);

        Book findBook =  bookRepository.findById(savedBookId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 book_id")
                );

        return findBook;
    }

    public Category createCategory_checkId(String name){
        CategoryRequestAddDto requestAddDto = new CategoryRequestAddDto();
        requestAddDto.setName(name);

        //when
        Long saveId = categoryService.save(requestAddDto);

        //then
        Category findCategory = categoryRepository.findById(saveId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 카테고리 ID")
                );

        Assertions.assertThat(findCategory.getName()).isEqualTo(requestAddDto.getName());

        return findCategory;
    }

}