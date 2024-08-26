package es.cic.curso.servidor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.cic.curso.servidor.model.Book;
import es.cic.curso.servidor.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService BookService;

    @PostMapping("/new")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = BookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
    List<Book> books = BookService.getAllBooks();
    return ResponseEntity.ok(books);
    }

    @GetMapping("/search")
    public ResponseEntity<Book> getBook(
    @RequestParam(required = true) String title,
    @RequestParam(required = true) String author,
    @RequestParam(required = false) int year) {
        Book bookToFind = new Book(title, author, year);
        Book book = BookService.getBook(bookToFind);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }
}