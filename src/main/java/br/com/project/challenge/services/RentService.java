package br.com.project.challenge.services;

import java.time.Instant;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Payment;
import br.com.project.challenge.entities.Rent;
import br.com.project.challenge.repositories.RentRepository;

@Service
public class RentService {

	@Autowired
	RentRepository rentRepository;

	public List<Rent> findAll() {
		return rentRepository.findAll();
	}

	public Rent findById(Long id) throws Exception {
		Optional<Rent> rent = rentRepository.findById(id);
		if (!rent.isPresent()) {
			throw new Exception("Rente nao encontrado!");
		}
		
		return rent.get();
	}

	public Rent insert(Rent rent) {
		rent.setRentExpirationDay(rent.getRentDay().plus(Period.ofDays(7)));
		return rentRepository.save(rent);
	}
	
	public void delete(Long id) {
		rentRepository.deleteById(id);
	}
	
	//public Rent update(Long id, Rent rent) {
	//	Rent entity = rentRepository.getOne(id);
	//	updateData(entity, rent);
	//	return rentRepository.save(entity);
	//}

	//private void updateData(Rent entity, Rent rent) {
	//entity.setRentStatus(rent.getRentStatus());
	//}
	
	public Rent delivery(Long id) throws Exception {
		Rent rent = findById(id);
		rent.setRentDelivery(Instant.now());
		
		Payment payment = new Payment();
		payment.setMoment(rent.getRentDelivery());
		payment.setRent(rent);
		rent.setPayment(payment);
		
		return insert(rent);
	}
	
	
	
}
