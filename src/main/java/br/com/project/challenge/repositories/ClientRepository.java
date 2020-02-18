package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
