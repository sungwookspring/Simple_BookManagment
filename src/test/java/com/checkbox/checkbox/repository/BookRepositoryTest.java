package com.checkbox.checkbox.repository;

import com.checkbox.checkbox.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional(readOnly = true)
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void 카테고리를_포함한_책엔티티_조회(){
        List<Book> findBooks = bookRepository.findAllWithCategoryName();

        for (Book book: findBooks){
            System.out.println("책 이름: " + book.getTitle());

            book.getBookCategories().forEach(bookCategory -> System.out.println("카테고리: " + bookCategory.getCategory().getName()));
        }
    }

    /***
     * 책은 SpringBoot Main함수에서 초기화
     */
    @Test
    public void 책이름_검색(){
        Book findBook = bookRepository.findByTitle("test1")
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 책")
                );
    }

    @Test
    public void 전체조회(){
        List<Book> findBooks = bookRepository.findAll();

        findBooks.forEach(book -> System.out.println(book.getTitle()));
    }
}