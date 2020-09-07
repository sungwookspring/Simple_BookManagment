package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Dto.BookRequestAddDto;
import com.checkbox.checkbox.domain.Dto.BookRequestUpdateDto;
import com.checkbox.checkbox.domain.Dto.BookResponseFindOneDto;
import com.checkbox.checkbox.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class Book_API_Controller {
    private final BookService bookService;

    @PostMapping("/book/api/add")
    public Long add(@RequestBody BookRequestAddDto requestAddDto){
        log.info("[*] restapi: add called");
        Long saveId = bookService.save(requestAddDto);

        return saveId;
    }

    @PutMapping("/book/api/update/{id}")
    public Long update(@PathVariable Long id, @RequestBody BookRequestUpdateDto requestUpdateDto) {
        log.info("[*] restapi: update called");
        Long updateId = bookService.update(id, requestUpdateDto);

        return updateId;
    }
}
