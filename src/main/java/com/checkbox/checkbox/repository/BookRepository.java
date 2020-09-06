package com.checkbox.checkbox.repository;

import com.checkbox.checkbox.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
