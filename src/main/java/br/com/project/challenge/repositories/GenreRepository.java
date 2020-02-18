package br.com.project.challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.challenge.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
