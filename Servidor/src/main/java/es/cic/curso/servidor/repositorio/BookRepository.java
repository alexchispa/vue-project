package es.cic.curso.servidor.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.curso.servidor.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}