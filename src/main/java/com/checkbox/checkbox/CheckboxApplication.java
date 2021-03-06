package com.checkbox.checkbox;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.domain.BookCategory;
import com.checkbox.checkbox.domain.Category;
import com.checkbox.checkbox.domain.Dto.Category.CategoryRequestAddDto;
import com.checkbox.checkbox.repository.BookRepository;
import com.checkbox.checkbox.service.BookCategoryService;
import com.checkbox.checkbox.service.BookService;
import com.checkbox.checkbox.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class CheckboxApplication {
	private final BookRepository bookRepository;
	private final CategoryService categoryService;
	private final BookService bookService;
	private final BookCategoryService bookCategoryService;

	public static void main(String[] args) {
		SpringApplication.run(CheckboxApplication.class, args);
	}

	@Bean
	@Transactional
	public CommandLineRunner AddBook() {
		return (args) -> {
			Book book1 = Book.builder()
					.title("test1")
					.author("author1")
					.readed(true)
					.build();
			Book book2 = Book.builder()
					.title("test2")
					.author("author2")
					.readed(true)
					.build();
			Book book3 = Book.builder()
					.title("test3")
					.author("author3")
					.readed(false)
					.build();
			Book book4 = Book.builder()
					.title("test4")
					.author("author5")
					.readed(false)
					.build();

			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);
			bookRepository.save(book4);
		};
	}

	@Bean
	public CommandLineRunner AddCategory() {
		return (args) -> {
			CategoryRequestAddDto categoryRequestAddDto1 = CategoryRequestAddDto.builder()
					.name("교양")
					.build();

			createCategoryHelper("교양");
			createCategoryHelper("인문");
			createCategoryHelper("과학");
		};
	}

	@Bean
	public CommandLineRunner AddBook_Category_Relation(){
		return (args) -> {
			bookService.setRelationship("test1", "교양");
			bookService.setRelationship("test1", "인문");
			bookService.setRelationship("test2", "인문");
			bookService.setRelationship("test3", "과학");
		};
	}

	private void createCategoryHelper(String name){
		CategoryRequestAddDto requestAddDto = CategoryRequestAddDto.builder()
						.name(name)
						.build();

		categoryService.save(requestAddDto);
	}
}
