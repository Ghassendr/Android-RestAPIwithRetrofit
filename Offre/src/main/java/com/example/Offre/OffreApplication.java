package com.example.Offre;

import com.example.Offre.dao.OffreRepository;
import com.example.Offre.entity.Offre;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OffreApplication {

	public static void main(String[] args) {
		SpringApplication.run(OffreApplication.class, args);
	}


	@Bean
	CommandLineRunner start (OffreRepository offreRepository){
		return args -> {

			offreRepository.save(new Offre(1 ,"iset","iset@gmail.com","lalal","ddd",1));
			offreRepository.save(new Offre(5 ,"waaaaaaaaa","waaaaaaaaa","waaaaaaaaa","waaaaaaaaa",8));
			offreRepository.save(new Offre(9,"waaaaaaaaa","waaaaaaaaa","waaaaaaaaa","waaaaaaaaa",8));
			offreRepository.findAll().forEach(System.out::println);
		};
	}
}
