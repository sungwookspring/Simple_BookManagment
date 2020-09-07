package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Dto.BookRequestAddDto;
import com.checkbox.checkbox.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Book_API_Controller {
    private final BookService bookService;

    @PostMapping("/book/api/add")
    public Long add(@RequestBody BookRequestAddDto requestAddDto){
        log.info("[*] called");
        Long saveId = bookService.save(requestAddDto);

        return saveId;
    }
}
