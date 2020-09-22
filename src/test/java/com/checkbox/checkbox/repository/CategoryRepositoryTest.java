package com.checkbox.checkbox.repository;

import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.service.CategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {
    @Autowired
    CategoryService categoryService;

    /***
     * 초기화 데이터는 springboot Main 함수에 존재
     */
    @Test
    public void 이름검색(){
        Category findCategory = categoryService.findByName("교양");

        System.out.println("카테고리 이름: " + findCategory.getName());
    }

}