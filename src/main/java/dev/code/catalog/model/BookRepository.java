package dev.code.catalog.model;

public interface BookRepository {
    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    Book save(Book book);

    void deleteByIsbn(String isbn);


}
