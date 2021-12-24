package com.gmdb.team5.pf7project.service;


import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
    public Boolean isAliveByName(String firstName, String lastName) {
        return personRepository.isAliveByName(firstName, lastName);
    }

    @Override
    public String findCountryByName(String firstName, String lastName) {
        return personRepository.findCountryByName(firstName, lastName);
    }
}
