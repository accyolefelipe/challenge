package br.com.project.challenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
