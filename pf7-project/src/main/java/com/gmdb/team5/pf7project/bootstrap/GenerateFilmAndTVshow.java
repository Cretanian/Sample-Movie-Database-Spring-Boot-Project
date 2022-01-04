package com.gmdb.team5.pf7project.bootstrap;

import com.gmdb.team5.pf7project.base.AbstractLogComponent;
import com.gmdb.team5.pf7project.domain.*;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
@Profile("dev")
@Order(2)
public class GenerateFilmAndTVshow extends AbstractLogComponent implements CommandLineRunner {
    private final TVShowService tvShowService;
    private final FilmService filmService;
    private final PersonService personService;
    private final Utils util = new Utils();

    String[] movieTitle = {"Pacific Rim", "Pacific Rim 2", "Avengers", "DeadPool",
            "Avengers: Infinity War", "Avengers: End Game", "SpiderMan", "Mortal Kombat", "Thor", "Fast and Furious",
            "Army of Theives", "Army of the deads", "Red Notice", "Hulk", "Oxygen"};

    String[] tvShowTitle = {"Game of Thrones", "Breaking Bad", "Witcher", "Money Heist",
            "Squid Game", "Ozak", "Hunter X Hunter", "Attack on Titan"};

    String[] tvShowEpisodeTitle = {"A new beginning", "Tales of Brad", "Mister Door", "All goes both ways",
            "The game of fisherman", "Down the road with Jones", "Check yourself", "No time left to clean"};


    private Role generateRandomRole(){

        int index  = util.getRandom().nextInt(13);
        switch (index) {
            case 1: return Role.Actor;
            case 2: return Role.Director;
            case 3: return Role.Producer;
            case 4: return Role.Writer;
            case 5: return Role.ExecutiveProducer;
            case 6: return Role.AssistantDirector;
            case 7: return Role.FilmEditor;
            case 8: return Role.SoundDesigner;
            case 9: return Role.CostumeDesigner;
            case 10: return Role.CameraOperator;
            case 11: return Role.BoomOperator;
            case 12: return Role.PhotographyDirector;
        }
        return null;
    }

    private Genre generateGenre() {
        int index  = util.generateRandomIntInRange(1,16);
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
        Set<Genre> genreSet = new HashSet<>();
        Genre genre;

        do{
            genre = generateGenre();
            genreSet.add(genre);
        }while (util.getRandom().nextBoolean());

        return genreSet;
    }

    public Rating generateRating() {
        int index  = util.generateRandomIntInRange(1,5);
        switch (index) {
            case 1: return Rating.one;
            case 2: return Rating.two;
            case 3: return Rating.three;
            case 4: return Rating.four;
            case 5: return Rating.five;
        }
        return null;
    }

    private void createMovies() {
        List<Film> films = new ArrayList<>();

        //fix age of person...

        for(int i = 0; i < movieTitle.length; ++i){
            films.add(
                    Film.builder()
                            .title(movieTitle[i])
                            .description("Here is an epic description!")
                            .releaseYear(util.generateRandomIntInRange(1930,2020))
                            .language(util.generateCountry())
                            .duration(util.generateRandomIntInRange(60,180))
                            .rating(generateRating())
                            .genre(generateRandomGenres())
                            .peopleCasted(new HashSet<>())
                            .build()
            );

            filmService.addItem(films.get(i), personService.find( (long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
            filmService.addItem(films.get(i), personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
            filmService.addItem(films.get(i), personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
        }

        logger.info("Created {} movies.", filmService.createAll(films).size());
    }

    private void createTVShowsWithEpisodes() {

        List<TVShow> tvShow = new ArrayList<>();

        //fix duration, episodes, seasons

        for(int i = 0; i <tvShowTitle.length ; ++i) {
            tvShow.add(
                    TVShow.builder()
                            .title(tvShowTitle[i])
                            .description("Here is an epic TVShow description!")
                            .releaseYear(util.generateRandomIntInRange(1990, 2020))
                            .language(util.generateCountry())
                            .duration(util.generateRandomIntInRange(60 * 5, 60 * 15))
                            .rating(generateRating())
                            .genre(generateRandomGenres())
                            .peopleCasted(new HashSet<>())
                            .numberOfEpisodes(util.generateRandomIntInRange(5, 15))
                            .numberOfSeasons(util.generateRandomIntInRange(1, 3))
//                            .episodes(new HashSet<>())
                            .build()
            );

            filmService.addItem(tvShow.get(i), personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
            filmService.addItem(tvShow.get(i), personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
            filmService.addItem(tvShow.get(i), personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());

        }

        //fix this
//        tvShow.get(0).getEpisodes().add(newEpisodes(0));
//        tvShow.get(0).getEpisodes().add(newEpisodes(1));
//        tvShow.get(1).getEpisodes().add(newEpisodes(2));
//        tvShow.get(1).getEpisodes().add(newEpisodes(3));
//        tvShow.get(2).getEpisodes().add(newEpisodes(4));
//        tvShow.get(2).getEpisodes().add(newEpisodes(5));
//        tvShow.get(3).getEpisodes().add(newEpisodes(6));
//        tvShow.get(3).getEpisodes().add(newEpisodes(7));

         logger.info("Created and associated {} TVShows.", tvShowService.createAll(tvShow).size());

    }

    private Film newEpisodes(int i) {
        Film episode = Film.builder()
                .title(tvShowEpisodeTitle[i])
                .description("Here is an epic Episode description!")
                .releaseYear(util.generateRandomIntInRange(1930, 2020))
                .language(util.generateCountry())
                .duration(util.generateRandomIntInRange(60, 180))
                .rating(generateRating())
                .genre(generateRandomGenres())
                .peopleCasted(new HashSet<>())
                .build();

        filmService.addItem(episode, personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(episode, personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(episode, personService.find((long) util.getRandom().nextInt(10 - 1) + 1), generateRandomRole());

        filmService.create(episode);
        return episode;
    }


    @Override
    public void run(String... args) {
        createMovies();
        createTVShowsWithEpisodes();

    }
}












