package dev.code.catalog.model;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class BookRepositoryImp implements BookRepository{

    private final Map<String,Book> store = new ConcurrentHashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return store.values();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return this.store.get(isbn);
    }

    @Override
    public Book save(Book book) {
        return this.store.put(book.isbn(),book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        this.store.remove(isbn);
    }
}
