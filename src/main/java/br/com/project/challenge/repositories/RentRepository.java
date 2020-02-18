package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {

}
