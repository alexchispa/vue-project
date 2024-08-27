package es.cic.curso.servidor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso.servidor.model.Book;
import es.cic.curso.servidor.repositorio.BookRepository;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

}
