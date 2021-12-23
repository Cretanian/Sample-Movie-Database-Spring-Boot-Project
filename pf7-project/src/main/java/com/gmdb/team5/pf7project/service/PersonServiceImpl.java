package com.gmdb.team5.pf7project.service;


import com.gmdb.team5.pf7project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService{
    //private final PersonRepository personRepository;

    @Override
    public JpaRepository<Person, Long> getRepository() {
        return null;
    }


    @Override
    public Person findByFullName(String firstName, String lastName) {
        return null;   //PersonRepository.findAll().stream().filter(c -> c.getEmail().equals(email)).findAny().orElse(null);
    }

    @Override
    public Boolean isAliveByID(Long id) {
        return null;   //PersonRepository.findAll().stream().filter(c -> c.getId().equals(id)).findAny().get().getIsAlive.orElse(null);
    }

    @Override
    public Boolean isAliveByFullName(String firstName, String lastName) {
        return null;
    }

    @Override
    public String wherePersonIsFromById(Long id) {
        return null;
    }

    @Override
    public String wherePersonIsFromByFullName(String firstName, String lastName) {
        return null;
    }
}
