package dev.code.catalog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record Book(

        @NotBlank(message = "ISBN must be provided")
        String isbn,
        @NotBlank(message = "Title must be provided")
        String title,
        @NotBlank(message = "Author must be provided")
        String author,

        @Positive(message = "Price must be greater than zero")
        double price

) {
}
