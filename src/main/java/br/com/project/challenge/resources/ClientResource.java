package br.com.project.challenge.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.challenge.entities.Client;
import br.com.project.challenge.services.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@Autowired
	ClientService clientService;

	@GetMapping
	public ResponseEntity<List<Client>> findAll() {
		List<Client> list = clientService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Client> findById(@PathVariable Long id) {
		Client obj = clientService.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
