package es.cic.curso.servidor.model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    public static List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Title", "Author", 2022));
        return books;
    }

    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}