package com.gmdb.team5.pf7project.bootstrap;

import com.gmdb.team5.pf7project.base.AbstractLogComponent;
import com.gmdb.team5.pf7project.domain.*;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class BaseContentCreatorRunner extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;
    private final TVShowService tvShowService;


    Random random = new Random();
    String[] isoCountryCodes = Locale.getISOCountries();

    String[] firstName = {"Stelios", "Nikos", "Giannis", "Manolis", "Kwstas", "Maria",
            "Eleni", "Anna", "Giwta", "Mariana", "Eleftheria", "Aristea", "Pavlos", "Stathis"};

    String[] lastName = {"Petropoulos", "Papadopoulos", "Stamatakis", "Maliarakis",
            "Moutsalis", "Petranis", "Argiros", "Rouvas", "Paparizoy", "Remos" };

    String[] movieTitle = {"Pacific Rim", "Pacific Rim 2", "Avengers", "DeadPool",
            "Avengers: Infinity War", "Avengers: End Game", "SpiderMan", "Mortal Kombat", "Thor", "Fast and Furious",
    "Army of Theives", "Army of the deads", "Red Notice", "Hulk", "Oxygen"};

    String[] tvShowTitle = {"Game of Thrones", "Breaking Bad", "Witcher", "Money Heist",
            "Squid Game", "Ozak", "Hunter X Hunter", "Attack on Titan"};

    String[] tvShowEpisodeTitle = {"A new beginning", "Tales of Brad", "Mister Door", "All goes both ways",
            "The game of fisherman", "Down the road with Jones", "Check yourself", "No time left to clean"};


    public Integer generateRandomAgeInRange(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public Boolean generateisAlive() {
        return random.nextBoolean();
    }

    public String generateFistName() {
        return firstName[random.nextInt(firstName.length)];
    }

    public String generateLastName() {
        return lastName[random.nextInt(lastName.length)];
    }

    private String generateCountry() {
        int index = random.nextInt(isoCountryCodes.length);
        Locale locale = new Locale("", isoCountryCodes[index]);
        return locale.getCountry();
    }

    private Rating generateRating() {
        int index  = generateRandomAgeInRange(1,5);
        switch (index) {
            case 1: return Rating.one;
            case 2: return Rating.two;
            case 3: return Rating.three;
            case 4: return Rating.four;
            case 5: return Rating.five;
        }
        return null;
    }

    private Genre generateGenre() {
        int index  = generateRandomAgeInRange(1,16);
        switch (index) {
            case 1: return Genre.Romance;
            case 2: return Genre.Horror;
            case 3: return Genre.Comedy;
            case 4: return Genre.Adventure;
            case 5: return Genre.Action;
            case 6: return Genre.SciFi;
            case 7: return Genre.Drama;
            case 8: return Genre.Documentary;
            case 9: return Genre.Mystery;
            case 10: return Genre.Supernatural;
            case 11: return Genre.Psychological;
            case 12: return Genre.SliceOfLife;
            case 13: return Genre.Fantasy;
            case 14: return Genre.Crime;
            case 15: return Genre.Thriller;
            case 16: return Genre.Animation;
        }
        return null;
    }

    private Set<Genre> generateRandomGenres(){
        Set<Genre> genre = new HashSet<>();

        do{
            genre.add(generateGenre());
        }while (random.nextBoolean());

        return genre;
    }

    private void createPeople() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            people.add(
                    Person.builder()
                            .id((long) i)
                            .firstName(generateFistName())
                            .lastName(generateLastName())
                            .YOB(generateRandomAgeInRange(1950, 2005))
                            .country(generateCountry())
                            .isAlive(generateisAlive())
                            .build()
            );
        }

        logger.info("Created {} people.", personService.createAll(people).size());
    }

    private void createMovies() {
        List<Film> films = new ArrayList<>();

        for(int i = 0; i < 15; ++i){
            films.add(
                    Film.builder()
                            .id((long) i)
                            .title(movieTitle[i])
                            .description("Here is an epic description!")
                            .releaseYear(generateRandomAgeInRange(1930,2020))
                            .language(generateCountry())
                            .duration(generateRandomAgeInRange(60,180))
                            .rating(generateRating())
                            .genre(generateRandomGenres())
                            .build()
            );
        }

        logger.info("Created {} movies.", filmService.createAll(films).size());
    }

    private void createTVShows() {

        List<TVShow> tvShow = new ArrayList<>();
        List<Film> films = new ArrayList<>();

        for(int i = 15; i < 23; ++i){
            tvShow.add(
                    TVShow.builder()
                            .id((long) i)
                            .title(tvShowTitle[i - 15])
                            .description("Here is an epic TVShow description!")
                            .releaseYear(generateRandomAgeInRange(1990,2020))
                            .language(generateCountry())
                            .duration(generateRandomAgeInRange(60*5,60*15))
                            .rating(generateRating())
                            .genre(generateRandomGenres())
                            .episodes(generateRandomAgeInRange(5,15))
                            .seasons(generateRandomAgeInRange(1,3))
                            .build()
            );

        }

        logger.info("Created and associated {} TVShows.", tvShowService.createAll(tvShow).size());

      //add here the more films(episodes)


    }

    private void createEpisodes() {
        List<Film> films = new ArrayList<>();

        for(int i = 23; i < 31; ++i){
            films.add(
                    Film.builder()
                            .id((long) i)
                            .title(tvShowEpisodeTitle[i - 23])
                            .description("Here is an epic episode description!")
                            .releaseYear(generateRandomAgeInRange(2014,2016))
                            .language(generateCountry())
                            .duration(generateRandomAgeInRange(60,180))
                            .rating(generateRating())
                            .build()
            );
        }

        logger.info("Created {} TVShow Episodes.", filmService.createAll(films).size());
    }

    @Override
    public void run(String... args) {

        createPeople();
        createMovies();
        createTVShows();
        createEpisodes();

    }
}

