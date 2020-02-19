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
		Optional<Book> book = bookRepository.findById(id);
		return book.get();
	}

	public Book insert(Book book) {
		return bookRepository.save(book);

	}
	
	public void delete(Long id) {
		bookRepository.deleteById(id);
	}
	
	public Book update(Long id, Book book) {
		Book entity = bookRepository.getOne(id);
		updateData(entity, book);
		return bookRepository.save(entity);
	}

	private void updateData(Book entity, Book book) {
		entity.setName(book.getName());
		entity.setAuthor(book.getAuthor());;
		entity.setRentPrice(book.getRentPrice());
		entity.setImgUrl(book.getImgUrl());

	}
}
