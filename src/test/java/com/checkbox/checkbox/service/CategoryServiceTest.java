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
        BookCategory findBookCategory = createBookCategory(savedBook.getId(), savedCategory.getId());

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

    @Test
    @Transactional
    public void createBook_createCategories_AndDoRelation(){
        // 책 생성
        Book savedBook =  createbook_checkId("테스트 책", "테스트 작가");

        //여러개 카테고리 생성과 테스트
        for(int i=0; i<10; i++){
            Category savedCategory = createCategory_checkId("테스트 카테고리" + Integer.toString(i));
            BookCategory findBookCategory = createBookCategory(savedBook.getId(), savedCategory.getId());
            checkValidation_bookCategory(savedBook, savedCategory, findBookCategory);
        }

        //책 한개에 연결된 다수의 카테고리를 리스트로 출력
        savedBook.getBookCategories().forEach(
                bookCategory -> System.out.println(bookCategory.getCategory().getName())
        );
    }

    private void checkValidation_bookCategory(Book savedBook, Category savedCategory, BookCategory findBookCategory){
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

    private BookCategory createBookCategory(Long book_id, Long category_id){
        BookCategoryRequestAddDto requestAddDto = new BookCategoryRequestAddDto();
        requestAddDto.setBook_id(book_id);
        requestAddDto.setCategory_id(category_id);

        Long savedBookCategoryId = bookCategoryService.save(requestAddDto);

        BookCategory findBookCategory = bookCategoryRepository.findById(savedBookCategoryId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 savedBookCategoryId")
                );

        return findBookCategory;
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