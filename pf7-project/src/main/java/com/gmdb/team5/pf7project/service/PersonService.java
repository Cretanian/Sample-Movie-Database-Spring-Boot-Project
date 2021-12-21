package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Long>{

    Person findByFullName (String firstName, String LastName);

    List<Person> findAlivePersons();
}
