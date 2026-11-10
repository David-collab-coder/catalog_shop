package dev.code.catalog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "books")
public record Book(

        @Id
        Long id,
        @NotBlank(message = "ISBN must be provided")
        String isbn,
        @NotBlank(message = "Title must be provided")
        String title,
        @NotBlank(message = "Author must be provided")
        String author,

        @Positive(message = "Price must be greater than zero")
        double price

) {

        public  static Book of(String isbn, String title,String author, double price){
                return new Book(null,isbn,title,author,price);
        }
}
