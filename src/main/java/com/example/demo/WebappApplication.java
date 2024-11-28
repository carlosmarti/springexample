package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRespository;

@SpringBootApplication
public class WebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRespository userRepository) {
		
		return args -> {
			
			Stream.of("John", "Kelly", "PDiddy", "Julie", "Peter").forEach(name ->
			{
				Users users = new Users(name, name.toLowerCase() + "@domain.com");
				userRepository.save(users);
			});
			
			userRepository.findAll().forEach(System.out::println);
		};
	}

}
