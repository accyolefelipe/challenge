package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Rent;
import br.com.project.challenge.repositories.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository rentRepository;

	public List<Rent> findAll() {
		return rentRepository.findAll();
	}

	public Rent findById(Long id) {
		Optional<Rent> obj = rentRepository.findById(id);
		return obj.get();
	}

	public Rent insert(Rent obj) {
		return rentRepository.save(obj);

	}
	
	public void delete(Long id) {
		rentRepository.deleteById(id);
	}
	
	public Rent update(Long id, Rent obj) {
		Rent entity = rentRepository.getOne(id);
		updateData(entity, obj);
		return rentRepository.save(entity);
	}

	private void updateData(Rent entity, Rent obj) {
		entity.setRentStatus(obj.getRentStatus());
	}
	
	
}
