package com.gmdb.team5.pf7project.bootstrap;

import com.gmdb.team5.pf7project.base.AbstractLogComponent;
import com.gmdb.team5.pf7project.domain.*;
import com.gmdb.team5.pf7project.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Profile("dev")
@Order(1)
public class GeneratePeople extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final Utils util = new Utils();

    String[] firstName = {"Stelios", "Nikos", "Giannis", "Manolis", "Kwstas", "Maria",
            "Eleni", "Anna", "Giwta", "Mariana", "Eleftheria", "Aristea", "Pavlos", "Stathis"};

    String[] lastName = {"Petropoulos", "Papadopoulos", "Stamatakis", "Maliarakis",
            "Moutsalis", "Petranis", "Argiros", "Rouvas", "Paparizoy", "Remos" };

    public Boolean generateIsAlive() {
        return util.getRandom().nextBoolean();
    }

    public String generateFistName() {
        return firstName[util.getRandom().nextInt(firstName.length)];
    }

    public String generateLastName() {
        return lastName[util.getRandom().nextInt(lastName.length)];
    }

    private void createPeople() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            people.add(
                    Person.builder()
                            .firstName(generateFistName())
                            .lastName(generateLastName())
                            .YOB(util.generateRandomIntInRange(1950, 2005))
                            .country(util.generateCountry())
                            .isAlive(generateIsAlive())
                            .build()
            );
        }

        logger.info("Created {} people.", personService.createAll(people).size());
    }

    @Override
    public void run(String... args) {
//        createPeople();
    }
}

