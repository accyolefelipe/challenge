package br.com.project.challenge.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.challenge.entities.Book;
import br.com.project.challenge.entities.Client;
import br.com.project.challenge.entities.Genre;
import br.com.project.challenge.entities.Payment;
import br.com.project.challenge.entities.Rent;
import br.com.project.challenge.entities.RentItem;
import br.com.project.challenge.entities.enums.RentStatus;
import br.com.project.challenge.repositories.BookRepository;
import br.com.project.challenge.repositories.ClientRepository;
import br.com.project.challenge.repositories.GenreRepository;
import br.com.project.challenge.repositories.RentItemRepository;
import br.com.project.challenge.repositories.RentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	RentRepository rentRepository;

	@Autowired
	GenreRepository genreRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	RentItemRepository rentItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Genre g1 = new Genre(null, "Romance");
		Genre g2 = new Genre(null, "Drama");
		Genre g3 = new Genre(null, "Sci-Fi");

		Book b1 = new Book(null, "The Nootbook", "Nicholas Sparks", 15.0, "");
		Book b2 = new Book(null, "The Martian", "Andy Weir", 25.0, "");
		Book b3 = new Book(null, "The Fault in Our Stars", "John Green", 20.0, "");

		genreRepository.saveAll(Arrays.asList(g1, g2, g3));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3));

		b1.getGenres().add(g1);
		b1.getGenres().add(g2);
		b2.getGenres().add(g3);
		b3.getGenres().add(g1);

		bookRepository.saveAll(Arrays.asList(b1, b2, b3));

		Client c1 = new Client(null, "Jaspion", "jaspion@tokusatsu.com", "99999999");
		Client c2 = new Client(null, "Jiban", "jiban@tokusatsu.com", "88888888");

		Rent r1 = new Rent(null, Instant.parse("2019-06-20T19:53:07Z"), RentStatus.WINTHIN_THE_TIME_LIMIT, c1);
		Rent r2 = new Rent(null, Instant.parse("2019-07-21T03:42:10Z"), RentStatus.DELAYED, c2);
		Rent r3 = new Rent(null, Instant.parse("2019-07-22T15:21:22Z"), RentStatus.WINTHIN_THE_TIME_LIMIT, c1);

		clientRepository.saveAll(Arrays.asList(c1, c2));
		rentRepository.saveAll(Arrays.asList(r1, r2, r3));

		RentItem ri1 = new RentItem(r1, b3, b3.getRentPrice());
		RentItem ri2 = new RentItem(r1, b1, b1.getRentPrice());
		RentItem ri3 = new RentItem(r2, b2, b2.getRentPrice());

		rentItemRepository.saveAll(Arrays.asList(ri1, ri2, ri3));
		
		Payment pay1 = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"), r1);
		r1.setPayment(pay1);

		rentRepository.save(r1);

	}

}
