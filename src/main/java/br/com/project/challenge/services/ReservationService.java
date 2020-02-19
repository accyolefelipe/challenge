package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Reservation;
import br.com.project.challenge.entities.enums.ReservationStatus;
import br.com.project.challenge.repositories.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		Optional<Reservation> reservation = reservationRepository.findById(id);
		return reservation.get();
	}

	public Reservation insert(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public void delete(Long id) {
		reservationRepository.deleteById(id);
	}
	
	//public Reservation update(Long id, Reservation reservation) {
	//	Reservation entity = reservationRepository.getOne(id);
	//	updateData(entity, reservation);
	//	return reservationRepository.save(entity);
	//}

	//private void updateData(Reservation entity, Reservation reservation) {
	//	entity.set
	//}
	
	public void cancelReservation(long id) throws Exception{
		Reservation reservation = findById(id);
		reservation.setReservationStatus(ReservationStatus.CANCELED);
		insert(reservation);		
	}
}
