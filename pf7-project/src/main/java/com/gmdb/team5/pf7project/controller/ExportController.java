package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.service.TVShowService;
import com.opencsv.CSVWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
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



    public void csvWriterGeneric(String filename, List<String[]> entries) {
        try {
            File theDir = new File("csv");
            if (!theDir.exists())
                if (!theDir.mkdirs())
                    throw new Exception("Unable to create csv dir at specified path");

            File myFile = new File("csv/" + filename + ".csv");

            CSVWriter writer = new CSVWriter(new FileWriter(myFile.getAbsolutePath()));

            for (String[] entry : entries) {
                writer.writeNext(entry);
            }
            writer.close();

            if (!myFile.createNewFile())
                throw new Exception("Unable to create file "+ filename +" at specified path.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //export csv for all people
    @GetMapping("/all")
    public void allTables(HttpServletResponse response) {

        //fix this to localy create a csv file and a json file

        exportPersonToCSV();
        exportFilmsToCSV();
        exportTVShowToCSV();
        exportPersonCastedToCSV();
        exportFilmGenreToCSV();
    }

    @GetMapping("/POEPLE")
    public void exportPersonToCSV() {
        List<Person> peoplelist = personService.findAll();
        rowsAffected.put("PEOPLE",peoplelist.size());
        String[] csvHeader = {"Person ID", "First Name", "Last Name", "YOB", "Country", "Is Alive"};
        List<String[]> myPeopleList = new ArrayList<>();

        myPeopleList.add(csvHeader);

        for (Person array : peoplelist) {
            String[] entry = new String[6];
            entry[0] = array.getId().toString();
            entry[1] = array.getFirstName();
            entry[2] = array.getLastName();
            entry[3] = array.getYOB().toString();
            entry[4] = array.getCountry();
            entry[5] = array.getIsAlive().toString();
            myPeopleList.add(entry);
        }

        csvWriterGeneric("PEOPLE", myPeopleList);

    }

    @GetMapping("/FILMS")
    public void exportFilmsToCSV() {
        List<Film> filmList = filmService.findAll();
        rowsAffected.put("FILMS",filmList.size());
        String[] csvHeader = {"Film ID", "Title", "Description", "Release Year", "Language", "Duration", "Rating"};
        List<String[]> myFilmList = new ArrayList<>();

        myFilmList.add(csvHeader);

        for (Film film : filmList) {
            String[] entry = new String[7];
            entry[0] = film.getId().toString();
            entry[1] = film.getTitle();
            entry[2] = film.getDescription();
            entry[3] = film.getReleaseYear().toString();
            entry[4] = film.getLanguage();
            entry[5] = film.getDuration().toString();
            entry[6] = film.getRating().toString();
            myFilmList.add(entry);
        }

        csvWriterGeneric("FILMS", myFilmList);
    }

    @GetMapping("/TVSHOWS")
    public void exportTVShowToCSV() {
        List<TVShow> tvShowList = tvShowService.findAll();
        rowsAffected.put("TVSHOWS",tvShowList.size());
        String[] csvHeader = {"Film ID", "NumberOfSeasons", "NumberOfEpisodes"};
        List<String[]> myTVshowList = new ArrayList<>();

        myTVshowList.add(csvHeader);

        for (TVShow tvShow : tvShowList) {
            String[] entry = new String[3];
            entry[0] = tvShow.getId().toString();
            entry[1] = tvShow.getNumberOfSeasons().toString();
            entry[2] = tvShow.getNumberOfEpisodes().toString();
            myTVshowList.add(entry);
        }

        csvWriterGeneric("TVSHOW", myTVshowList);
    }

    @GetMapping("/CASTED_PERSON")
    public void exportPersonCastedToCSV() {

        List<Object[]> castedPersonList = filmService.findAllCastedPeople();
        rowsAffected.put("CASTED_PERSON",castedPersonList.size());
        final String[] csvHeader = {"ID", "Person ID", "Film ID", "Role"};
        List<String[]> myCastedPersonList  = new ArrayList<>();
        myCastedPersonList.add(csvHeader);

        for (Object[] castedPersonCasted : castedPersonList) {
            String[] entry = new String[4];
            entry[0] = castedPersonCasted[0].toString();
            entry[1] = castedPersonCasted[3].toString();
            entry[2] = castedPersonCasted[2].toString();
            entry[3] = castedPersonCasted[1].toString();

            myCastedPersonList.add(entry);
        }
        csvWriterGeneric("CASTED_PERSON", myCastedPersonList);
    }

    @GetMapping("/FILMGENRE")
    public void exportFilmGenreToCSV() {
        List<Object[]> filmGenreList = filmService.findAllFilmGenre();
        rowsAffected.put("FILMGENRE",filmGenreList.size());
        String[] csvHeader = {"Film ID", "Genre ID"};
        List<String[]> myfilmGenreList  = new ArrayList<>();
        myfilmGenreList.add(csvHeader);

        for (Object[] filmgenre : filmGenreList) {
            String[] entry = new String[2];
            entry[0] = filmgenre[0].toString();
            entry[1] = filmgenre[1].toString();
            myfilmGenreList.add(entry);

        }
        csvWriterGeneric("FILMGENRE", myfilmGenreList);
    }

}