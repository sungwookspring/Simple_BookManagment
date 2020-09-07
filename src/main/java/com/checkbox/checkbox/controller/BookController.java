package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Dto.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.BookResponseListallDto;
import com.checkbox.checkbox.repository.BookRepository;
import com.checkbox.checkbox.service.BookService;
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
    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping("/book/add")
    public String addForm(@ModelAttribute BookRequestAddDto bookRequestAddDto){
        return "book/add";
    }

    @PostMapping("/book/add")
    public String add(@ModelAttribute BookRequestAddDto bookRequestAddDto){
        bookService.save(bookRequestAddDto);
        return "redirect:/book/list";
    }

    @GetMapping("/book/list")
    public String listAll(Model model){
        List<BookResponseListallDto> books = bookService.findAll();

        model.addAttribute("books", books);
        return "book/list";
    }
}
