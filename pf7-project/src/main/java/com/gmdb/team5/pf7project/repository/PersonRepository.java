package com.gmdb.team5.pf7project.repository;

import com.gmdb.team5.pf7project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select o from Person o where o.firstName = ?1 AND o.lastName = ?2")
    Person findByName (String firstName,String lastName);

    @Query("select o.isAlive from Person o where o.firstName = ?1 AND o.lastName = ?2")
    Boolean isAliveByName (String firstName, String lastName);

    @Query("select o.country from Person o where o.firstName = ?1 AND o.lastName = ?2")
    String findCountryByName (String firstName, String lastName);

}
