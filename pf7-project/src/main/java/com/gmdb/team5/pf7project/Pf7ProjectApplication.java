package com.gmdb.team5.pf7project;

import com.gmdb.team5.pf7project.repository.PersonRepository;
import com.gmdb.team5.pf7project.service.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@RequiredArgsConstructor
@SpringBootApplication
public class Pf7ProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(Pf7ProjectApplication.class, args);

	}

}
