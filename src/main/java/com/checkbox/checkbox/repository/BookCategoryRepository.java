package com.checkbox.checkbox.repository;

import com.checkbox.checkbox.domain.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
}
