package com.example.bookproject.repoTests;

import com.example.bookproject.model.Book;
import com.example.bookproject.model.BookData;
import com.example.bookproject.repositories.BookDataRepo;
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
import java.util.Calendar;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class BookDataRepoTest {
    private static final Logger log = LoggerFactory.getLogger(BookDataRepoTest.class);

    @Autowired
    BookRepo bookRepo;

    @Autowired
    BookDataRepo bookDataRepo;

    private BookData bookData;

    @Before
    public void setUp(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(1980,Calendar.MARCH,15);
        Book book = bookRepo.findById(1L).get();
        bookData = new BookData(book,"Kobo","https://www.kobo.com/gr/en/ebook/the-handmaid-s-tale-5", "Science Fiction",
                4.3,700,350, calendar.getTime(), 10.99, false);
    }

    @Test
    @Transactional
    public void saveTest(){
        log.info("Testing save() of BookDataRepo: ");
        log.info("Items in db: {}", bookDataRepo.count());
        bookDataRepo.save(bookData);
        log.info("Items in db after new entry: {}", bookDataRepo.count());
    }

    @Test
    @Transactional
    public void deleteByIdTest(){
        log.info("Testing deleteById() of BookDataRepo: ");
        if (bookDataRepo.count() > 0) {
            log.info("Items in db: {}", bookDataRepo.count());
            bookDataRepo.deleteById(1L);
            log.info("Items in db after delete: {}", bookDataRepo.count());
        }
        else{
            log.info("No items to delete.");
        }
    }

    @Test
    @Transactional
    public void deleteAllTest(){
        log.info("Testing deleteAll() of BookDataRepo: ");
        log.info("Items in db: {}", bookDataRepo.count());
        bookDataRepo.deleteAll();
        log.info("Items in db after delete: {}", bookDataRepo.count());
    }

    @Test
    public void findByIdTest(){
        log.info("Testing findById() of BookDataRepo: ");
        if(bookDataRepo.count() >= 0){
            log.info("{}", bookDataRepo.findById(1L));
        }
        else{
            log.info("No items in db");
        }
    }

    @Test
    public void findAllTest(){
        log.info("Testing findById() of BookDataRepo: ");
        log.info("{}", bookDataRepo.findAll());
    }

    @After
    public void tearDown(){ bookData = null; }
}
