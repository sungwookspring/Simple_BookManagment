package com.checkbox.checkbox.controller;

import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.Category.CategoryRequestAddDto;
import com.checkbox.checkbox.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class Category_Controller {
    private final CategoryService categoryService;

    @GetMapping("/category/list")
    public String findAll(Model model){
        List<CategoryRequestAddDto> categoryRequestAddDtos = new ArrayList<>();
        List<Category> categories = categoryService.findAll();

        categories.forEach(category -> categoryRequestAddDtos.add(
                CategoryRequestAddDto
                .builder()
                .name(category.getName())
                .build()
        ));

        model.addAttribute("categories", categoryRequestAddDtos);

        return "category/list";
    }


}
