package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person>{

    Person findByName (String firstName,String lastName);

    List<Person> findByCountry (String country);

    List<Person> findByIsAlive (Boolean isAlive);

}
