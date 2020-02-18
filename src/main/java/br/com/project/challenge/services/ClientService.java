package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Client;
import br.com.project.challenge.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.get();
	}
}
