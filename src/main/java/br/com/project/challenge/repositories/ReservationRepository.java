package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
