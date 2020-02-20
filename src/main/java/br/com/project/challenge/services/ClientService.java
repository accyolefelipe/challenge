package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Client;
import br.com.project.challenge.repositories.ClientRepository;
import br.com.project.challenge.services.exceptions.DatabaseException;
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
		try {
			clientRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(e);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Client update(Long id, Client client) {
		try {
			Client entity = clientRepository.getOne(id);
			updateData(entity, client);
			return clientRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Client entity, Client client) {
		entity.setName(client.getName());
		entity.setEmail(client.getEmail());
		entity.setPhone(client.getPhone());

	}
}
