package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PersonController extends AbstractController<Person> {
    private final PersonService personService;
    private final FilmService filmService;

    @Override
    protected BaseService<Person> getBaseService() {
        return personService;
    }

    @GetMapping(params = {"firstname", "lastname"})
    public Person findByName(@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        return personService.findByName(firstName, lastName);
    }

    @GetMapping(params = {"country"})
    public List<Person> findByCountry(@RequestParam("country") String country) {
        return personService.findByCountry(country);
    }

    @GetMapping(params = {"isAlive"})
    public List<Person> findByIsAlive(@RequestParam("isAlive") Boolean isAlive) {
        return personService.findByIsAlive(isAlive);
    }

    @GetMapping(params = {"id"}, headers = {"action=ReturnFilmsCasted"})
    public ResponseEntity<ApiResponse<Map<Person, List<Film>>>> getFilmsCasted(@RequestParam("id") Long id) {
        Map<Person, List<Film>> myMap = new HashMap<>();
        Person person = personService.find(id);
        List<Film> filmList = filmService.findFilmByPerson(person);
        for (Film iterator : filmList)
            iterator.setPeopleCasted(null);
        myMap.put(person, filmList);
        return ResponseEntity.ok(ApiResponse.<Map<Person, List<Film>>>builder().data(myMap).build());
    }

}