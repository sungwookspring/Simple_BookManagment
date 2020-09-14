package com.checkbox.checkbox.domain.Dto.BookCategory;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestAddForm_CategoryDto {
    private Long category_id;
    private String name;

    @Builder
    public RequestAddForm_CategoryDto(Long id, String name){
        this.category_id = id;
        this.name = name;
    }
}
