package dev.code.catalog.service;

import dev.code.catalog.model.Book;
import dev.code.catalog.model.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findByIsbn(String isbn){
        return this.bookRepository.findByIsbn(isbn);
    }

    public Iterable<Book> viewAll(){
        return this.bookRepository.findAll();
    }

    public Book addBook(Book book){
        return this.bookRepository.save(book);
    }

    public void delete(String isbn){
        this.bookRepository.deleteByIsbn(isbn);
    }
}
