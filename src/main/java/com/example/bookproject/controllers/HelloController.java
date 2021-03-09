package com.example.bookproject.controllers;

import com.example.bookproject.repositories.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private AuthorRepo authorRepo;

    public HelloController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/")
    public String index() {
        return authorRepo.findAll().toString();
    }
}
