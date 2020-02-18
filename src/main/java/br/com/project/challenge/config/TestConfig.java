package br.com.project.challenge.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.project.challenge.entities.Client;
import br.com.project.challenge.entities.Rent;
import br.com.project.challenge.repositories.ClientRepository;
import br.com.project.challenge.repositories.RentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	RentRepository rentRepository;

	@Override
	public void run(String... args) throws Exception {

		Client c1 = new Client(null, "Jaspion", "jaspion@tokusatsu.com", "99999999");
		Client c2 = new Client(null, "Jiban", "jiban@tokusatsu.com", "88888888");

		Rent r1 = new Rent(null, Instant.parse("2019-06-20T19:53:07Z"), c1);
		Rent r2 = new Rent(null, Instant.parse("2019-07-21T03:42:10Z"), c2);
		Rent r3 = new Rent(null, Instant.parse("2019-07-22T15:21:22Z"), c1);

		clientRepository.saveAll(Arrays.asList(c1, c2));
		rentRepository.saveAll(Arrays.asList(r1, r2, r3));

	}

}
