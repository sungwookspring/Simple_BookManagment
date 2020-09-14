package com.checkbox.checkbox.domain.Dto.BookCategory;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RequestAddForm_BookDto {
    private Long id;
    private String title;

    @Builder
    public RequestAddForm_BookDto(Long id, String title){
        this.id = id;
        this.title = title;
    }
}
