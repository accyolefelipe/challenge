package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Client;
import br.com.project.challenge.repositories.ClientRepository;
import br.com.project.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> client = clientRepository.findById(id);
		return client.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client insert(Client client) {
		return clientRepository.save(client);

	}
	
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}
	
	public Client update(Long id, Client client) {
		Client entity = clientRepository.getOne(id);
		updateData(entity, client);
		return clientRepository.save(entity);
	}

	private void updateData(Client entity, Client client) {
		entity.setName(client.getName());
		entity.setEmail(client.getEmail());
		entity.setPhone(client.getPhone());

	}
}
