package br.com.project.challenge.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		Genre genre = genreService.findById(id);
		return ResponseEntity.ok().body(genre);
	}

	@PostMapping
	public ResponseEntity<Genre> insert(@RequestBody Genre genre) {
		genre = genreService.insert(genre);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(genre.getId()).toUri();
		return ResponseEntity.created(uri).body(genre);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		genreService.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Genre> update(@PathVariable Long id, @RequestBody Genre genre){
		genre = genreService.update(id, genre);
		return ResponseEntity.ok().body(genre);
	}

}
