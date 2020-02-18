package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
