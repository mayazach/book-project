package com.example.bookproject.repositories;

import com.example.bookproject.model.Author;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "author")
public interface AuthorRepo extends PagingAndSortingRepository<Author,Long> {
}
