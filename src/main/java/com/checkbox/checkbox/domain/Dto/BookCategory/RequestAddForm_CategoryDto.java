package com.checkbox.checkbox.domain.Dto.BookCategory;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestAddForm_CategoryDto {
    private Long id;
    private String name;

    @Builder
    public RequestAddForm_CategoryDto(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
