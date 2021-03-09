CREATE TABLE IF NOT EXISTS BOOK (
    id INT(10) NOT NULL AUTO_INCREMENT,
    title VARCHAR(1024) NOT NULL ,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS AUTHOR (
    id INT(10) NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(256) NOT NULL ,
    last_name VARCHAR(256) NOT NULL ,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS BOOKAUTHOR(
    id INT(10) NOT NULL AUTO_INCREMENT,
    bookid INT(10) NOT NULL ,
    authorid INT(10) NOT NULL ,
    PRIMARY KEY (id)
    ,
    CONSTRAINT bookauthorid_bookid_FK
    FOREIGN KEY (bookid)
    REFERENCES BOOK (id)
    ON DELETE CASCADE
    ,
    CONSTRAINT bookauthorid_authorid_FK
    FOREIGN KEY (authorid)
    REFERENCES AUTHOR (id)
    ON DELETE CASCADE
    );

CREATE INDEX bookauthorid_bookid_FK ON BOOKAUTHOR(bookid);
CREATE INDEX bookauthorid_authorid_FK ON BOOKAUTHOR(authorid);

CREATE TABLE IF NOT EXISTS BOOKDATA (
    id INT(10) NOT NULL AUTO_INCREMENT,
    bookid INT(10) NOT NULL ,
    website VARCHAR(256) NOT NULL ,
    link VARCHAR(1024) NOT NULL ,
    genre VARCHAR(256),
    rating FLOAT,
    rating_count INT,
    page_count INT,
    publication_date DATE,
    price FLOAT,
    part_of_series BOOLEAN,
    is_good FLOAT,
    is_new FLOAT,
    is_popular FLOAT,
    is_cheap FLOAT,
    is_short FLOAT,
    PRIMARY KEY (id)
    ,
    CONSTRAINT bookdataid_bookid_FK
    FOREIGN KEY (bookid)
    REFERENCES BOOK(id)
    ON DELETE CASCADE
    );

CREATE INDEX bookdataid_bookid_FK ON BOOKDATA(bookid);

INSERT IGNORE INTO BOOK (id, title) VALUES (1, 'The Handmaid\'s Tale');

INSERT IGNORE INTO AUTHOR (id, first_name, last_name) VALUES (1, 'Margaret', 'Atwood');

INSERT IGNORE INTO BOOKAUTHOR (id, bookid, authorid) VALUES (1,1,1);

INSERT IGNORE BOOKDATA (id, bookid, website, link, genre, rating, rating_count, page_count, publication_date, price, part_of_series, is_good, is_new, is_popular, is_cheap, is_short)
VALUES (1,1,'Goodreads','https://www.goodreads.com/book/show/38447.The_Handmaid_s_Tale?ac=1&from_search=true&qid=UDfmDioWn0&rank=1','Fiction',4.23,800,353,'1982-03-20',8.99,true,0.97,0.72,0.94,0.81,0.67);