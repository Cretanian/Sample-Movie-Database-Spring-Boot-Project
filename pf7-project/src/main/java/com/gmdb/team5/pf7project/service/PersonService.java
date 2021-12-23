package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Person;

public interface PersonService extends BaseService<Person>{

    Person findByName (String firstName,String lastName);

    Boolean isAliveByName (String firstName, String lastName);

    String findCountryByName (String firstName, String lastName);

}
