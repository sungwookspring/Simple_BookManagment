package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Dto.BookRequestAddDto;
import com.checkbox.checkbox.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class Book_API_Controller {
    private final BookService bookService;

    @GetMapping("/book/api/add")
    public String addForm(@ModelAttribute BookRequestAddDto bookRequestAddDto){
        return "bookAPI/add";
    }

    @PostMapping("/book/api/add")
    public @ResponseBody Long add(@RequestBody BookRequestAddDto requestAddDto){
        Long saveId = bookService.save(requestAddDto);

        return saveId;
    }
}
