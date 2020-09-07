package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Dto.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.BookResponseListallDto;
import com.checkbox.checkbox.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public Long save(BookRequestAddDto requestAddDto){
        Book book = requestAddDto.toEntity();

        return bookRepository.save(book).getId();
    }

    public List<BookResponseListallDto> findAll(){
        List<BookResponseListallDto> responseDto = new ArrayList<>();
        List<Book> books = bookRepository.findAll();

        books.forEach(book -> responseDto.add(BookResponseListallDto.builder()
                .entity(book).build()));

        return responseDto;
    }
}
