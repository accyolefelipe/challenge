package br.com.project.challenge.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.challenge.entities.Genre;
import br.com.project.challenge.repositories.GenreRepository;

@Service
public class GenreService {

	@Autowired
	GenreRepository genreRepository;

	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	public Genre findById(Long id) {
		Optional<Genre> obj = genreRepository.findById(id);
		return obj.get();
	}
}
