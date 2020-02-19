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
		Optional<Genre> genre = genreRepository.findById(id);
		return genre.get();
	}
	
	public Genre insert(Genre genre) {
		return genreRepository.save(genre);

	}
	
	public void delete(Long id) {
		genreRepository.deleteById(id);
	}
	
	public Genre update(Long id, Genre genre) {
		Genre entity = genreRepository.getOne(id);
		updateData(entity, genre);
		return genreRepository.save(entity);
	}

	private void updateData(Genre entity, Genre genre) {
		entity.setName(genre.getName());
	}
}
