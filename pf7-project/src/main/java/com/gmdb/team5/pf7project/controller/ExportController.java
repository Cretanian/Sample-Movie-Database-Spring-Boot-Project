package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.base.AbstractLogComponent;
import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.service.TVShowService;
import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/export")
public class ExportController extends AbstractLogComponent {

    private final JSONObject jsonObject = new JSONObject();
    private final FilmService filmService;
    private final PersonService personService;
    private final TVShowService tvShowService;
    private String[] csvHeader;
    private List<String[]> myGenericList;
    private String[] entry;

    public void csvWriterGeneric(String filename, List<String[]> entries) {
        try {
            File theDir = new File("csv");
            if (!theDir.exists())
                if (!theDir.mkdirs())
                    logger.error("Unable to create csv dir at specified path");

            File myFile = new File("csv/" + filename + ".csv");

            CSVWriter writer = new CSVWriter(new FileWriter(myFile.getAbsolutePath()));

            for (String[] entry : entries)
                writer.writeNext(entry);

            writer.close();

            if (!myFile.exists())
                myFile.createNewFile();

        }catch (Exception e){
            logger.error("{}",e.getMessage());
        }
    }

    private void createJson(){
        try {
            FileWriter file = new FileWriter("csv/effectedRows.json");
            file.write(jsonObject.toJSONString());
            file.close();
            logger.info("The effectedRows.json file created successfully");
        } catch ( IOException e) {
            logger.error("{}",e.getMessage());
        }
    }

    @GetMapping("/all")
    public void allTables(HttpServletResponse response) {
        exportPersonToCSV();
        exportFilmsToCSV();
        exportTVShowToCSV();
        exportPersonCastedToCSV();
        exportFilmGenreToCSV();
        logger.info("All .csv files created successfully");
        createJson();
    }

    @GetMapping("/PEOPLE")
    public void exportPersonToCSV() {
        final List<Person> peoplelist = personService.findAll();
        jsonObject.put("PEOPLE",peoplelist.size());
        csvHeader = new String[]{"Person ID", "First Name", "Last Name", "YOB", "Country", "Is Alive"};
        myGenericList = new ArrayList<>();

        myGenericList.add(csvHeader);

        for (Person array : peoplelist) {
            entry = new String[6];
            entry[0] = array.getId().toString();
            entry[1] = array.getFirstName();
            entry[2] = array.getLastName();
            entry[3] = array.getYOB().toString();
            entry[4] = array.getCountry();
            entry[5] = array.getIsAlive().toString();
            myGenericList.add(entry);
        }
        csvWriterGeneric("PEOPLE", myGenericList);
        logger.info("The PEOPLE.csv created successfully");

    }

    @GetMapping("/FILMS")
    public void exportFilmsToCSV() {
        final List<Film> filmList = filmService.findAll();
        jsonObject.put("FILMS",filmList.size());
        csvHeader = new String[]{"Film ID", "Title", "Description", "Release Year", "Language", "Duration", "Rating"};
        myGenericList = new ArrayList<>();

        myGenericList.add(csvHeader);

        for (Film film : filmList) {
            entry = new String[7];
            entry[0] = film.getId().toString();
            entry[1] = film.getTitle();
            entry[2] = film.getDescription();
            entry[3] = film.getReleaseYear().toString();
            entry[4] = film.getLanguage();
            entry[5] = film.getDuration().toString();
            entry[6] = film.getRating().toString();
            myGenericList.add(entry);
        }

        csvWriterGeneric("FILMS", myGenericList);
        logger.info("The FILMS.csv created successfully");
    }

    @GetMapping("/TVSHOW")
    public void exportTVShowToCSV() {
        final List<TVShow> tvShowList = tvShowService.findAll();
        jsonObject.put("TVSHOWS",tvShowList.size());
        csvHeader = new String[]{"Film ID", "NumberOfSeasons", "NumberOfEpisodes"};
        myGenericList = new ArrayList<>();

        myGenericList.add(csvHeader);

        for (TVShow tvShow : tvShowList) {
            String[] entry = new String[3];
            entry[0] = tvShow.getId().toString();
            entry[1] = tvShow.getNumberOfSeasons().toString();
            entry[2] = tvShow.getNumberOfEpisodes().toString();
            myGenericList.add(entry);
        }

        csvWriterGeneric("TVSHOW", myGenericList);
        logger.info("The TVSHOW.csv created successfully");

    }

    @GetMapping("/CASTED_PERSON")
    public void exportPersonCastedToCSV() {
        List<Object[]> castedPersonList = filmService.findAllCastedPeople();
        jsonObject.put("CASTED_PERSON",castedPersonList.size());
        csvHeader = new String[]{"ID", "Person ID", "Film ID", "Role"};
        myGenericList  = new ArrayList<>();
        myGenericList.add(csvHeader);

        for (Object[] castedPersonCasted : castedPersonList) {
            entry = new String[4];
            entry[0] = castedPersonCasted[0].toString();
            entry[1] = castedPersonCasted[3].toString();
            entry[2] = castedPersonCasted[2].toString();
            entry[3] = castedPersonCasted[1].toString();

            myGenericList.add(entry);
        }
        csvWriterGeneric("CASTED_PERSON", myGenericList);
        logger.info("The CASTED_PERSON.csv created successfully");

    }

    @GetMapping("/FILMGENRE")
    public void exportFilmGenreToCSV() {
        List<Object[]> filmGenreList = filmService.findAllFilmGenre();
        jsonObject.put("FILMGENRE",filmGenreList.size());
        csvHeader = new String[]{"Film ID", "Genre ID"};
        myGenericList  = new ArrayList<>();
        myGenericList.add(csvHeader);

        for (Object[] filmgenre : filmGenreList) {
            entry = new String[2];
            entry[0] = filmgenre[0].toString();
            entry[1] = filmgenre[1].toString();
            myGenericList.add(entry);

        }
        csvWriterGeneric("FILMGENRE", myGenericList);
        logger.info("The FILMGENRE.csv created successfully");
    }

}