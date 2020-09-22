package com.checkbox.checkbox.repository;

import com.checkbox.checkbox.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b")
    List<Book> findAllWithCategoryName();

    Optional<Book> findByTitle(String title);
}
