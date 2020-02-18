package br.com.project.challenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.challenge.entities.Book;
import br.com.project.challenge.services.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

	@Autowired
	BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> findAll() {
		List<Book> list = bookService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id) {
		Book obj = bookService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
