package com.checkbox.checkbox.domain.Dto.Category;

import com.checkbox.checkbox.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryRequestAddDto {
    public String name;

    public Category toEntity(){
        return Category.builder()
                .name(this.name)
                .build();
    }

    @Builder
    public CategoryRequestAddDto(String name){
        this.name = name;
    }
}
