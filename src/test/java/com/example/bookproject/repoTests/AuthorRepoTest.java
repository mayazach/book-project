package com.example.bookproject.repoTests;

import com.example.bookproject.model.Author;
import com.example.bookproject.repositories.AuthorRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class AuthorRepoTest {
    private static final Logger log = LoggerFactory.getLogger(AuthorRepoTest.class);

    @Autowired
    AuthorRepo authorRepo;

    private Author author;

    @Before
    public void setUp(){ author = new Author("Neil", "Gaiman"); }

    @Test
    @Transactional
    public void saveTest(){
        log.info("Testing save() of AuthorRepo: ");
        log.info("Items in db: {}", authorRepo.count());
        authorRepo.save(author);
        log.info("Items in db after new entry: {}", authorRepo.count());
    }

    @Test
    @Transactional
    public void deleteByIdTest(){
        log.info("Testing deleteById() of AuthorRepo: ");
        if (authorRepo.count() > 0) {
            log.info("Items in db: {}", authorRepo.count());
            authorRepo.deleteById(1L);
            log.info("Items in db after delete: {}", authorRepo.count());
        }
        else{
            log.info("No items to delete.");
        }
    }

    @Test
    @Transactional
    public void deleteAllTest(){
        log.info("Testing deleteAll() of AuthorRepo: ");
        log.info("Items in db: {}", authorRepo.count());
        authorRepo.deleteAll();
        log.info("Items in db after delete: {}", authorRepo.count());
    }

    @Test
    @Transactional
    public void findByIdTest(){
        log.info("Testing findById() of AuthorRepo: ");
        if(authorRepo.count() >= 0){
            author = authorRepo.findById(1L).get();
            log.info("{}", author);
            log.info("Books: {}", author.getBooks());
        }
        else{
            log.info("No items in db");
        }
    }

    @Test
    public void findAllTest(){
        log.info("Testing findById() of AuthorRepo: ");
        log.info("{}", authorRepo.findAll());
    }

    @After
    public void tearDown(){ author = null; }
}
