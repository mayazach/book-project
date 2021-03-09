package com.example.bookproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "BOOKDATA", schema = "books")
public class BookData implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private Book book;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "link", nullable = false)
    private String link;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private double rating;

    @Column(name = "rating_count")
    private int ratingCount;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "price")
    private double price;

    @Column(name = "part_of_series")
    private boolean partOfSeries;

    @Column(name = "is_good")
    private double isGood;

    @Column(name = "is_new")
    private double isNew;

    @Column(name = "is_popular")
    private double isPopular;

    @Column(name = "is_cheap")
    private double isCheap;

    @Column(name = "is_short")
    private double isShort;

    protected BookData() {
    }

    public BookData(Book book, String website, String link, String genre, double rating, int ratingCount, int pageCount, Date publicationDate, double price, boolean partOfSeries) {
        this.book = book;
        this.website = website;
        this.link = link;
        this.genre = genre;
        this.rating = rating;
        this.ratingCount = ratingCount;
        this.pageCount = pageCount;
        this.publicationDate = publicationDate;
        this.price = price;
        this.partOfSeries = partOfSeries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPartOfSeries() {
        return partOfSeries;
    }

    public void setPartOfSeries(boolean partOfSeries) {
        this.partOfSeries = partOfSeries;
    }

    public double getIsGood() {
        return isGood;
    }

    public void setIsGood(double isGood) {
        this.isGood = isGood;
    }

    public double getIsNew() {
        return isNew;
    }

    public void setIsNew(double isNew) {
        this.isNew = isNew;
    }

    public double getIsPopular() {
        return isPopular;
    }

    public void setIsPopular(double isPopular) {
        this.isPopular = isPopular;
    }

    public double getIsCheap() {
        return isCheap;
    }

    public void setIsCheap(double isCheap) {
        this.isCheap = isCheap;
    }

    public double getIsShort() {
        return isShort;
    }

    public void setIsShort(double isShort) {
        this.isShort = isShort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookData bookData = (BookData) o;
        return Double.compare(bookData.rating, rating) == 0 && ratingCount == bookData.ratingCount && pageCount == bookData.pageCount && Double.compare(bookData.price, price) == 0 && partOfSeries == bookData.partOfSeries && Double.compare(bookData.isGood, isGood) == 0 && Double.compare(bookData.isNew, isNew) == 0 && Double.compare(bookData.isPopular, isPopular) == 0 && Double.compare(bookData.isCheap, isCheap) == 0 && Double.compare(bookData.isShort, isShort) == 0 && Objects.equals(id, bookData.id) && Objects.equals(book, bookData.book) && Objects.equals(website, bookData.website) && Objects.equals(link, bookData.link) && Objects.equals(genre, bookData.genre) && Objects.equals(publicationDate, bookData.publicationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, website, link, genre, rating, ratingCount, pageCount, publicationDate, price, partOfSeries, isGood, isNew, isPopular, isCheap, isShort);
    }

    @Override
    public String toString() {
        return "BookData{" +
                "book=" + book +
                ", website='" + website + '\'' +
                ", link='" + link + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", ratingCount=" + ratingCount +
                ", pageCount=" + pageCount +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", partOfSeries=" + partOfSeries +
                ", isGood=" + isGood +
                ", isNew=" + isNew +
                ", isPopular=" + isPopular +
                ", isCheap=" + isCheap +
                ", isShort=" + isShort +
                '}';
    }
}
