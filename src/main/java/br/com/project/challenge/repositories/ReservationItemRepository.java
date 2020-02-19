package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.ReservationItem;

public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {

}
