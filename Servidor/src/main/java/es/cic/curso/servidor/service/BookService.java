package es.cic.curso.servidor.service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import es.cic.curso.servidor.model.Book;

@Service
public class BookService {

    private final List<Book> books = Collections.synchronizedList(new LinkedList<>());

    public synchronized Book addBook(Book book) {
        boolean bookAdded = books.add(book);
        if (bookAdded) {
            return book;
        }
        return null;
    }

    public synchronized Book getBook(Book book) {
        int bookIndex = books.indexOf(book);
        if (bookIndex == -1) {
            return null;
        }
        return books.get(bookIndex);
    }

    public List<Book> getAllBooks() {
        synchronized (books) {
            return new LinkedList<>(books);
        }
    }
}