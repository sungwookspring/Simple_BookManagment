package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.Book.BookRequestUpdateDto;
import com.checkbox.checkbox.domain.Dto.Book.BookResponseFindOneDto;
import com.checkbox.checkbox.domain.Dto.Book.BookResponseListallDto;
import com.checkbox.checkbox.repository.BookRepository;
import com.checkbox.checkbox.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Book> books = bookService.findAll();
        List<BookResponseListallDto> responseDto = new ArrayList<>();

        books.forEach(book -> responseDto.add(BookResponseListallDto.builder()
                .entity(book).build()));

        model.addAttribute("books", responseDto);
        return "book/list";
    }

    @GetMapping("/book/update/{id}")
    public String updateForm(@PathVariable Long id, Model model){
        BookResponseFindOneDto findBook = bookService.findOneById(id);

        model.addAttribute("book", findBook);
        return "book/update";
    }

    @PostMapping("/book/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute BookRequestUpdateDto requestUpdateDto) {
        log.info("[*] called");
        bookService.update(id, requestUpdateDto);

        return "redirect:/book/list";
    }

    @GetMapping("/book/delete/{id}")
    public String delete(@PathVariable Long id){
        bookService.delete(id);

        return "redirect:/book/list";
    }

    /***
     * RESTAPI Form
     */

    @GetMapping("/book/api/add")
    public String restapi_addAPIForm(@ModelAttribute BookRequestAddDto bookRequestAddDto){
        return "bookAPI/add";
    }

    @GetMapping("/book/api/list")
    public String restapi_listAll(Model model){
        List<Book> books = bookService.findAll();
        List<BookResponseListallDto> responseDto = new ArrayList<>();

        books.forEach(book -> responseDto.add(BookResponseListallDto.builder()
                .entity(book).build()));

        model.addAttribute("books", responseDto);
        return "bookAPI/list";
    }

    @GetMapping("/book/api/update/{id}")
    public String restapi_updateForm(@PathVariable Long id, Model model){
        BookResponseFindOneDto findBook = bookService.findOneById(id);

        model.addAttribute("book", findBook);
        return "bookAPI/update";
    }
}
