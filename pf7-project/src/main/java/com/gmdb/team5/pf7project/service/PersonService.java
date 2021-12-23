package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Person;

public interface PersonService extends BaseService<Person>{

    Person findByFullName (String firstName,String lastName);

    Boolean isAliveByID(Long id);

    Boolean isAliveByFullName (String firstName, String lastName);

    String wherePersonIsFromById (Long id);

    String wherePersonIsFromByFullName (String firstName, String lastName);

}
