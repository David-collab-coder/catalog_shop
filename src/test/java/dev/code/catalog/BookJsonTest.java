package dev.code.catalog;

import dev.code.catalog.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
public class BookJsonTest {
    @Autowired
    private  JacksonTester<Book> tester;



    @Test
    void serializeTest() throws IOException {
        Book book = new Book("1234","Cloud Native","Thomas Vitale",23.4);

        JsonContent<Book> bookJsonContent = tester.write(book);
        assertThat(bookJsonContent).isNotNull();
        assertThat(bookJsonContent).extractingJsonPathStringValue("@.isbn").isEqualTo(book.isbn());
        assertThat(bookJsonContent).extractingJsonPathNumberValue("@.price").isEqualTo(book.price());

    }
    @Test
    void deserializeTest() throws IOException {
        var bookJson = """
                {
                "isbn":"1234",
                "title":"Cloud Native",
                "author":"Thomas Vitale",
                "price":23.0
                }
                """;

        Book book = tester.parseObject(bookJson);

        assertThat(book.isbn()).isEqualTo("1234");
        assertThat(tester.parseObject(bookJson))
                .usingRecursiveComparison()
                .isEqualTo(new Book("1234","Cloud Native","Thomas Vitale",23.0));

    }
}
