package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Dto.BookRequestAddDto;
import com.checkbox.checkbox.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/book/add")
    public String addForm(@ModelAttribute BookRequestAddDto bookRequestAddDto){
        return "book/add";
    }

    @PostMapping("/book/add")
    public String add(@ModelAttribute BookRequestAddDto bookRequestAddDto){
        Book book = Book.builder()
                .title((bookRequestAddDto.getTitle()))
                .author((bookRequestAddDto.getAuthor()))
                .build();

        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/list")
    public String listAll(Model model){
        List<Book> books = bookRepository.findAll();
        model.addAttribute("books", books);
        return "book/list";
    }
}
