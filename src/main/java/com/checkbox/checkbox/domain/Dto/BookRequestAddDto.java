package com.checkbox.checkbox.domain.Dto;

import com.checkbox.checkbox.domain.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequestAddDto {
   private String title;
   private String author;
   private boolean isreaded;

   public Book toEntity(){
      return Book.builder()
              .title(this.title)
              .author(this.author)
              .readed(this.isreaded)
              .build();
   }
}
