package dev.code.catalog.model;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {

    Book findByIsbn(String isbn);

    void deleteByIsbn(String isbn);
}
