package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Person;

import java.util.List;


public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService{

    @Override
    public Person findByFullName(String firstName, String LastName) {
        return null;
    }

    @Override
    public List<Person> findAlivePersons() {
        return null;
    }
}
