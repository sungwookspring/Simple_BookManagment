package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.BookCategory;
import com.checkbox.checkbox.repository.BookCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

    @Transactional
    public Long save(BookCategory bookCategory){
        return bookCategoryRepository.save(bookCategory).getId();
    }
}
