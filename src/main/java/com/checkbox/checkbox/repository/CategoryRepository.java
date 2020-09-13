package com.checkbox.checkbox.repository;

import com.checkbox.checkbox.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
