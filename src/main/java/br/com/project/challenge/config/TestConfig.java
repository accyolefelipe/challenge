package br.com.project.challenge.config;

import java.time.Instant;
import java.time.LocalDate;
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
import br.com.project.challenge.entities.Reservation;
import br.com.project.challenge.entities.ReservationItem;
import br.com.project.challenge.entities.enums.ReservationStatus;
import br.com.project.challenge.repositories.BookRepository;
import br.com.project.challenge.repositories.ClientRepository;
import br.com.project.challenge.repositories.GenreRepository;
import br.com.project.challenge.repositories.RentItemRepository;
import br.com.project.challenge.repositories.RentRepository;
import br.com.project.challenge.repositories.ReservationItemRepository;
import br.com.project.challenge.repositories.ReservationRepository;

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

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	ReservationItemRepository reservationItemRepository;

	@Override
	public void run(String... args) throws Exception {
		Genre g1 = new Genre(null, "Romance");
		Genre g2 = new Genre(null, "Drama");
		Genre g3 = new Genre(null, "Sci-Fi");
		Genre g4 = new Genre(null, "Unknown");

		Book b1 = new Book(null, "The Nootbook", "Nicholas Sparks", 15.0, "");
		Book b2 = new Book(null, "The Martian", "Andy Weir", 25.0, "");
		Book b3 = new Book(null, "The Fault in Our Stars", "John Green", 20.0, "");
		Book b4 = new Book(null, "teste reserva", "desconhecido", 100.0, "");
		Book b5 = new Book(null, "teste reserva2", "desconhecido", 90.0, "");

		genreRepository.saveAll(Arrays.asList(g1, g2, g3, g4));
		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));

		b1.getGenres().add(g1);
		b1.getGenres().add(g2);
		b2.getGenres().add(g3);
		b3.getGenres().add(g1);
		b4.getGenres().add(g4);
		b5.getGenres().add(g4);

		bookRepository.saveAll(Arrays.asList(b1, b2, b3, b4, b5));

		Client c1 = new Client(null, "Jaspion", "jaspion@tokusatsu.com", "99999999");
		Client c2 = new Client(null, "Jiban", "jiban@tokusatsu.com", "88888888");
		Client c3 = new Client(null, "test3", "teste3@gmail.com", "111");
		Client c4 = new Client(null, "test4", "teste4@gmail.com", "222");
		Instant data1 = Instant.parse("2019-06-20T19:53:07Z");
		Instant data2 = Instant.parse("2019-06-28T19:53:07Z");
		
		Rent r1 = new Rent(null, c1, data1, data2, null);
		Rent r2 = new Rent(null, c2, data1, data2, null);
		Rent r3 = new Rent(null, c1, data1, data2, null);

		Reservation res1 = new Reservation(null, LocalDate.of(2020, 02, 18), LocalDate.of(2020, 02, 25),
				ReservationStatus.CONFIRMED, c3);
		Reservation res2 = new Reservation(null, LocalDate.of(2020, 02, 18), LocalDate.of(2020, 02, 25),
				ReservationStatus.CONFIRMED, c4);

		clientRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		rentRepository.saveAll(Arrays.asList(r1, r2, r3));
		reservationRepository.saveAll(Arrays.asList(res1, res2));

		RentItem ri1 = new RentItem(r1, b3, b3.getRentPrice());
		RentItem ri2 = new RentItem(r1, b1, b1.getRentPrice());
		RentItem ri3 = new RentItem(r2, b2, b2.getRentPrice());

		ReservationItem resi1 = new ReservationItem(res1, b4, b4.getRentPrice());
		ReservationItem resi2 = new ReservationItem(res1, b5, b5.getRentPrice());

		rentItemRepository.saveAll(Arrays.asList(ri1, ri2, ri3));
		reservationItemRepository.saveAll(Arrays.asList(resi1, resi2));

		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), r1);
		r1.setPayment(pay1);

		rentRepository.save(r1);

	}

}
