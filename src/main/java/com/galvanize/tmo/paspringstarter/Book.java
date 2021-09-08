package com.galvanize.tmo.paspringstarter;

public class Book {

    private long id;
    private String author;
    private String title;
    private int yearPublished;


    public Book() {}

    public Book(long id, String author, String title, int yearPublished ) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.id = id;
    }

    public Book(String author, String title, int yearPublished ) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public long getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setId(long id) {
        this.id = id;
    }
}
