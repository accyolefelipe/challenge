package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.RentItem;

public interface RentItemRepository extends JpaRepository<RentItem, Long> {

}
