package dev.code.catalog;

import dev.code.catalog.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.client.RestTestClient;

//@WebMvcTest(value = {BookController.class})
@AutoConfigureRestTestClient
@SpringBootTest
public class BookControllerTest {


    @Autowired
    private RestTestClient testClient;

    @Test
    void viewAllEndPointTest(){
        testClient.get()
                .uri("/books")
                .exchange()
                .expectStatus().isOk();
    }
    @Test
    public  void testPostEnPoint(){
        testClient.post()
                .uri("/books")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Book.of("1234","T1","A1",23.4))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Book.class);
    }
}
