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

    @GetMapping(params = {"f","l"})
    public Person findByName(@RequestParam("f") String firstName, @RequestParam("l") String lastName ) {
        return personService.findByName(firstName,lastName);
    }

    @GetMapping(params = {"c"})
    public List<Person> findByCountry(@RequestParam("c") String country) {
        return personService.findByCountry(country);
    }

    @GetMapping(params = {"i"})
    public List<Person> findByIsAlive(@RequestParam("i") Boolean isAlive) {
        return personService.findByIsAlive(isAlive);
    }

    @GetMapping(params = {"g"}, headers = {"action=ReturnFilmsCasted"})
    public ResponseEntity<ApiResponse<Map<Person,List<Film>>>> testMe(@RequestParam("g") Long id) {
        Map<Person,List<Film>> myMap = new HashMap<>();
        Person person = personService.find(id);
        List<Film> filmList = filmService.findFilmByPerson(person);
        for(Film iterator : filmList)
            iterator.setPeopleCasted(null);         //check this and think about it. works but not best practise
        myMap.put(person,filmList);
        return ResponseEntity.ok(ApiResponse.<Map<Person,List<Film>>>builder().data(myMap).build());
    }

    //export csv for all people
    @GetMapping("/exportPersonDB")
    public void exportPearsonToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=people_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Person> findPeople = personService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Person ID", "First Name", "Last Name", "YOB", "Country", "Is Alive"};
        String[] nameMapping = {"id", "firstName", "lastName", "YOB", "country", "isAlive"};

        csvWriter.writeHeader(csvHeader);

        for (Person person : findPeople) {
            csvWriter.write(person, nameMapping);
        }

        csvWriter.close();
    }

    //export csv for all people
    //maybe not here but here for now because i dont care anymore
    @GetMapping("/exportPersonCastedDB")
    public void exportPersonCastedToCSV(HttpServletResponse response) throws IOException {
      /*  response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=people_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Person> findPeople = personService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Person ID", "First Name", "Last Name", "YOB", "Country", "Is Alive"};
        String[] nameMapping = {"id", "firstName", "lastName", "YOB", "country", "isAlive"};

        csvWriter.writeHeader(csvHeader);

        for (Person person : findPeople) {
            csvWriter.write(person, nameMapping);
        }

        csvWriter.close();

       */

        //TODO
    }
}
