package dev.code.catalog.web;

import dev.code.catalog.model.Book;
import dev.code.catalog.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> viewAll(){
        return this.bookService.viewAll();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Book save(@RequestBody Book book){
        return this.bookService.addBook(book);
    }

    @GetMapping("/{isbn}")
    public Book viewBookDetails(@PathVariable("isbn") String isbn){
        return this.bookService.findByIsbn(isbn);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("isbn") String isbn){
        this.bookService.delete(isbn);
    }
}
