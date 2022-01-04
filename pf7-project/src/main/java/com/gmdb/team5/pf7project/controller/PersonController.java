package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;

    @Override
    protected BaseService<Person> getBaseService() {
        return personService;
    }

    @GetMapping(params = {"f","l"})
    public Person findByName(@RequestParam("f") String firstName, @RequestParam("l") String lastName ) {
        return personService.findByName(firstName,lastName);
    }

    @GetMapping
    public List<Person> findByCountry(@RequestParam("c") String country) {
        return personService.findByCountry(country);
    }

    @GetMapping(params = {"i"})
    public List<Person> findByIsAlive(@RequestParam("i") Boolean isAlive) {
        return personService.findByIsAlive(isAlive);
    }

}
