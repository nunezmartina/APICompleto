package com.example.inicial1;

import com.example.inicial1.entities.*;
import com.example.inicial1.repositories.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Inicial1Application {
	private PersonaRepository personaRepository;

	public static void main(String[] args) {

		SpringApplication.run(Inicial1Application.class, args);

		System.out.println("funcionando");


	}

	@Bean
	@Transactional
	CommandLineRunner init(PersonaRepository personaRepository, DomicilioRepository domicilioRepository, LocalidadRepository localidadRepository) {
		return args -> {


			// Creo un objeto persona
			Persona persona1 = Persona.builder().
					nombre("Hsin Yu").apellido("Lin").dni(3849738).
					build();

			personaRepository.save(persona1);


		};
	}
	}









