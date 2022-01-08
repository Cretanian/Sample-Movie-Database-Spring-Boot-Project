package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.CastedPerson;
import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.CsvMapWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.io.ICsvMapWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/export")
public class ExportController {

    //create JSON with rows

    private final FilmService filmService;
    private final PersonService personService;
    private final TVShowService tvShowService;
    private final Map<String,Integer> rowsAffected;


    //export csv for all people
    @GetMapping("/all")
    public void allTables(HttpServletResponse response) throws IOException {

        //fix this

        exportPearsonToCSV(response);
        exportFilmsToCSV(response);
        exportTVShowToCSV(response);
        exportPersonCastedToCSV(response);
        exportFilmGenreToCSV(response);
    }

    //export csv for all people
    @GetMapping("/PERSON")
    public void exportPearsonToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=PEOPLE_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Person> findPeople = personService.findAll();

        rowsAffected.put("PEOPLE",findPeople.size());

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Person ID", "First Name", "Last Name", "YOB", "Country", "Is Alive"};
        String[] nameMapping = {"id", "firstName", "lastName", "YOB", "country", "isAlive"};

        csvWriter.writeHeader(csvHeader);

        for (Person person : findPeople) {
            csvWriter.write(person, nameMapping);
        }

        csvWriter.close();
    }

    //export csv for all films
    @GetMapping("/FILMS")
    public void exportFilmsToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=FILMS_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Film> findFilm = filmService.findAll();
        rowsAffected.put("FILMS",findFilm.size());


        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Film ID", "Title", "Description", "Release Year", "Language", "Duration", "Rating"};
        String[] nameMapping = {"id", "title", "description", "releaseYear", "language", "duration", "rating"};

        csvWriter.writeHeader(csvHeader);

        for (Film film : findFilm) {
            csvWriter.write(film, nameMapping);
        }

        csvWriter.close();
    }

    //export csv for all tvShows
    @GetMapping("/TVSHOWS")
    public void exportTVShowToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=TVSHOWS_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<TVShow> findTVShow = tvShowService.findAll();
        rowsAffected.put("TVSHOWS",findTVShow.size());

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Film ID", "NumberOfSeasons", "NumberOfEpisodes"};
        String[] nameMapping = {"id", "numberOfSeasons", "numberOfEpisodes"};

        csvWriter.writeHeader(csvHeader);

        for (TVShow tvShow : findTVShow) {
            csvWriter.write(tvShow, nameMapping);
        }

        csvWriter.close();
    }

    //export csv for all casted person
    @GetMapping("/CASTED_PERSON")
    public void exportPersonCastedToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=CASTED_PERSON_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Object[]> findCastedPerson = filmService.findAllCastedPeople();
        rowsAffected.put("CASTED_PERSON",findCastedPerson.size());

        ICsvMapWriter mapWriter = new CsvMapWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        final String[] csvHeader = {"ID", "Person ID", "Film ID", "Role"};
        mapWriter.writeHeader(csvHeader);

        for (Object[] castedPersonCasted : findCastedPerson) {
            Map<String, Object> entry = new HashMap<>();
            entry.put(csvHeader[0], castedPersonCasted[0]);
            entry.put(csvHeader[1], castedPersonCasted[3]);
            entry.put(csvHeader[2], castedPersonCasted[2]);
            entry.put(csvHeader[3], castedPersonCasted[1]);

            mapWriter.write(entry, csvHeader);
        }
        mapWriter.close();
    }

    //export csv for all filmgenre
    @GetMapping("/FILMGENRE")
    public void exportFilmGenreToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=FILMGENRE_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Object[]> findFilmGenre = filmService.findAllFilmGenre();
        rowsAffected.put("FILMGENRE",findFilmGenre.size());

        ICsvMapWriter mapWriter = new CsvMapWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Film ID", "Genre ID"};
        mapWriter.writeHeader(csvHeader);

     for (Object[] castedPersonCasted : findFilmGenre) {
            Map<String, Object> entry = new HashMap<>();
            entry.put(csvHeader[0], castedPersonCasted[0]);
            entry.put(csvHeader[1], castedPersonCasted[1]);

            mapWriter.write(entry, csvHeader);
        }
        mapWriter.close();
    }

}