package dev.code.catalog;

import dev.code.catalog.model.Book;
import dev.code.catalog.model.BookRepository;
import dev.code.catalog.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }

    @Bean
    ApplicationRunner init(BookRepository bookService){
        return args -> {
            Book book = Book.of("1234","Spring Cloud Native","Thomas Vitale",69.4);
            Book book1 = Book.of("1235","Pro Spring Boot 3","Felipe Guiterez",59.4);
            Book book2 = Book.of("1236","Spring AI in action","Craig Wails",55.4);

            bookService.saveAll(List.of(book,book1,book2));
        };
    }

}
