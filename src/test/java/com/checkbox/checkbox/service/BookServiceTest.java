package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.Book.BookResponseFindOneDto;
import com.checkbox.checkbox.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void 책등록(){
        //given
        BookRequestAddDto bookRequestAddDto = new BookRequestAddDto();
        bookRequestAddDto.setTitle("title");
        bookRequestAddDto.setAuthor("author");

        //when
        Long saveId = bookService.save(bookRequestAddDto);

        //then
        Book findBook = bookRepository.findById(saveId)
                .orElseThrow(
                        () -> new IllegalStateException("id is not exist")
                );

        Assertions.assertThat(findBook.getTitle()).isEqualTo(bookRequestAddDto.getTitle());
        Assertions.assertThat(findBook.getAuthor()).isEqualTo(bookRequestAddDto.getAuthor());
    }

    @Test
    public void 책등록_조회(){
        //given
        BookRequestAddDto bookRequestAddDto = new BookRequestAddDto();
        bookRequestAddDto.setTitle("title");
        bookRequestAddDto.setAuthor("author");

        //when
        Long saveId = bookService.save(bookRequestAddDto);
        BookResponseFindOneDto findBook = bookService.findOneById(saveId);

        //then
        Assertions.assertThat(findBook.getTitle()).isEqualTo(bookRequestAddDto.getTitle());
        Assertions.assertThat(findBook.getAuthor()).isEqualTo(bookRequestAddDto.getAuthor());

    }
}