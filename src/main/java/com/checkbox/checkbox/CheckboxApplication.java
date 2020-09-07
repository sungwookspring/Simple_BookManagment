package com.checkbox.checkbox;

import com.checkbox.checkbox.domain.Book;
import com.checkbox.checkbox.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class CheckboxApplication {
	private final BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(CheckboxApplication.class, args);
	}

	@Bean
	public CommandLineRunner Register() {
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
}
