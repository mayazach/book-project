package com.example.bookproject.repoTests;

import com.example.bookproject.model.Book;
import com.example.bookproject.repositories.BookRepo;
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
public class BookRepoTest {
    private static final Logger log = LoggerFactory.getLogger(BookRepoTest.class);

    @Autowired
    private BookRepo bookRepo;

    private Book book;

    @Before
    public void setUp(){
        book = new Book("Good omens");
    }

    @Test
    @Transactional
    public void saveTest(){
        log.info("Testing save() of BookRepo: ");
        log.info("Items in db: {}", bookRepo.count());
        bookRepo.save(book);
        log.info("Items in db after new entry: {}", bookRepo.count());
    }

    @Test
    @Transactional
    public void deleteByIdTest(){
        log.info("Testing deleteById() of bookRepo: ");
        if (bookRepo.count() > 0) {
            log.info("Items in db: {}", bookRepo.count());
            bookRepo.deleteById(1L);
            log.info("Items in db after delete: {}", bookRepo.count());
        }
        else{
            log.info("No items to delete.");
        }
    }

    @Test
    @Transactional
    public void deleteAllTest(){
        log.info("Testing deleteAll() of bookRepo: ");
        log.info("Items in db: {}", bookRepo.count());
        bookRepo.deleteAll();
        log.info("Items in db after delete: {}", bookRepo.count());
    }

    @Test
    public void findByIdTest(){
        log.info("Testing findById() of bookRepo: ");
        if(bookRepo.count() >= 0){
            log.info("{}", bookRepo.findById(1L));
        }
        else{
            log.info("No items in db");
        }
    }

    @Test
    public void findAllTest(){
        log.info("Testing findById() of bookRepo: ");
        log.info("{}", bookRepo.findAll());
    }

    @After
    public void tearDown(){ book = null; }
}
