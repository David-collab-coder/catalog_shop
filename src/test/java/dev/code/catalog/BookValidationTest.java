package dev.code.catalog;

import dev.code.catalog.model.Book;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BookValidationTest {

    private static Validator validator;


    @BeforeAll
    static void init(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator =factory.getValidator();
    }

    @Test
    void bookDetailsProvidedBetter(){
        Book book = new Book("1234","Cloud Native","Thomas Vitale",23.4);

        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        assertThat(validate).isEmpty();

    }

    @Test
    void testWhenIsbnIsBlank(){
        Book book = new Book("","Tr","A1",23.4);
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        assertThat(validate).hasSize(1);
        assertThat(validate.iterator().next().getMessage()).isEqualTo("ISBN must be provided");
    }

    @Test
    void multipleViolationsTest(){
        Book book = new Book("1234","tr","ai",-10);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);

        assertThat(violations).hasSize(1);
//        assertThat(violations.iterator().next().getMessage()).isEqualTo("ISBN must be provided");
        assertThat(violations.iterator().next().getMessage()).isEqualTo("Price must be greater than zero");
    }
}
