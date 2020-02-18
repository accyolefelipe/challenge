package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Book;
import br.com.project.challenge.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	public Book findById(Long id) {
		Optional<Book> obj = bookRepository.findById(id);
		return obj.get();
	}

	public Book insert(Book obj) {
		return bookRepository.save(obj);

	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
}
