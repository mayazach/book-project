package com.example.bookproject.repositories;

import com.example.bookproject.model.BookData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "bookdata")
public interface BookDataRepo extends PagingAndSortingRepository<BookData,Long> {
}
