package com.example.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.jpa.models.Author;
import com.example.jpa.repositories.AuthorRepository;

@SpringBootApplication
@EnableJpaAuditing
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository repository) {
		return args -> {
			Author author = Author.builder().name("INGENIO").build();

			repository.save(author);
		};
	}

}
