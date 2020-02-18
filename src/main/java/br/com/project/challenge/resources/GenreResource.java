package br.com.project.challenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.challenge.entities.Genre;
import br.com.project.challenge.services.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {

	@Autowired
	GenreService genreService;

	@GetMapping
	public ResponseEntity<List<Genre>> findAll() {
		List<Genre> list = genreService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Genre> findById(@PathVariable Long id) {
		Genre obj = genreService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
