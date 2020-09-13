package com.checkbox.checkbox.service;

import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.Category.CategoryRequestAddDto;
import com.checkbox.checkbox.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void save(){
        //given
        CategoryRequestAddDto requestAddDto = new CategoryRequestAddDto();
        requestAddDto.setName("책");

        //when
        Long saveId = categoryService.save(requestAddDto);

        //then
        Category findCategory = categoryRepository.findById(saveId)
                .orElseThrow(
                        () -> new IllegalStateException("존재하지 않은 카테고리 ID")
                );

        Assertions.assertThat(findCategory.getName()).isEqualTo(requestAddDto.getName());

    }

}