package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService{
    private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return personRepository;
    }

    @Override
    public Person findByName(String firstName, String lastName) {
        return personRepository.findByName(firstName, lastName);
    }

    @Override
    public List<Person> findByCountry(String country) {
        return personRepository.findByCountry(country);
    }

    @Override
    public List<Person> findByIsAlive(Boolean isAlive) {
        return personRepository.findByIsAlive(isAlive);
    }

}
