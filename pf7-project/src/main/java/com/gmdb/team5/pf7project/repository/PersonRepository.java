package com.gmdb.team5.pf7project.repository;

import com.gmdb.team5.pf7project.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select o from Person o where o.firstName = ?1 AND o.lastName = ?2")
    Person findByName (String firstName,String lastName);

    List<Person> findByCountry (String country);

    List<Person> findByIsAlive (Boolean isAlive);

}
