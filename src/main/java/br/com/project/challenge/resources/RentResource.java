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

import br.com.project.challenge.entities.Rent;
import br.com.project.challenge.services.RentService;

@RestController
@RequestMapping(value = "/rents")
public class RentResource {

	@Autowired
	RentService rentService;

	@GetMapping
	public ResponseEntity<List<Rent>> findAll() {
		List<Rent> list = rentService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Rent> findById(@PathVariable Long id) {
		Rent obj = rentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Rent> insert(@RequestBody Rent obj) {
		obj = rentService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		rentService.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Rent> update(@PathVariable Long id, @RequestBody Rent obj){
		obj = rentService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
