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

import br.com.project.challenge.entities.Reservation;
import br.com.project.challenge.services.ReservationService;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationResource {

	@Autowired
	ReservationService reservationService;

	@GetMapping
	public ResponseEntity<List<Reservation>> findAll() {
		List<Reservation> list = reservationService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Reservation> findById(@PathVariable Long id) {
		Reservation reservation = reservationService.findById(id);
		return ResponseEntity.ok().body(reservation);
	}

	@PostMapping
	public ResponseEntity<Reservation> insert(@RequestBody Reservation reservation) {
		reservation = reservationService.insert(reservation);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(reservation.getId()).toUri();
		return ResponseEntity.created(uri).body(reservation);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		reservationService.delete(id);
		return ResponseEntity.noContent().build();

	}

	//@PutMapping(value = "/{id}")
	//public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation reservation) {
	//	reservation = reservationService.update(id, reservation);
	//	return ResponseEntity.ok().body(reservation);
	//}

	@PutMapping(value = "/cancel/{id}")
	public ResponseEntity<Reservation> update(@PathVariable long id) throws Exception {
		reservationService.cancelReservation(id);
		return ResponseEntity.ok().body(null);
	}

}
