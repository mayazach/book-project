package com.example.bookproject.repositories;

import com.example.bookproject.model.Author;
import com.example.bookproject.model.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "books", path = "book")
public interface BookRepo extends PagingAndSortingRepository<Book,Long> {
    List<Book> findBooksByTitleAndAuthorsIn(String title, Iterable<Author> authors);
}
