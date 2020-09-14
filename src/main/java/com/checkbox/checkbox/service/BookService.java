package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestUpdateDto;
import com.checkbox.checkbox.domain.Dto.Book.BookResponseFindOneDto;
import com.checkbox.checkbox.domain.Dto.Book.BookResponseListallDto;
import com.checkbox.checkbox.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public Long save(BookRequestAddDto requestAddDto){
        Book book = requestAddDto.toEntity();

        return bookRepository.save(book).getId();
    }

    public List<Book> findAll(){
        List<Book> books = bookRepository.findAll();

        return books;
    }

    public BookResponseFindOneDto findOneById(Long id){
        Book book =  bookRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 ID")
                );

        return BookResponseFindOneDto.builder()
                .entity(book)
                .build();
    }

    @Transactional
    public Long update(Long id, BookRequestUpdateDto requestUpdateDto){
        Book findBook = bookRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 ID")
                );

        findBook.update(requestUpdateDto.getTitle(),
                    requestUpdateDto.getAuthor(),
                    requestUpdateDto.isReaded());

        return id;
    }

    @Transactional
    public Long delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 ID로 삭제 실패")
                );

        bookRepository.delete(book);

        return id;
    }
}
