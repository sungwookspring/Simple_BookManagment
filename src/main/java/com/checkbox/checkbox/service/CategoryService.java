package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.Category.CategoryRequestAddDto;
import com.checkbox.checkbox.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    @Transactional
    public Long save(CategoryRequestAddDto requestAddDto){
        Long saveId = categoryRepository.save(requestAddDto.toEntity()).getId();

        return saveId;
    }

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByName(String name){
        Category findCategory = categoryRepository.findByName(name)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 카테고리")
                );
        return findCategory;
    }
}
