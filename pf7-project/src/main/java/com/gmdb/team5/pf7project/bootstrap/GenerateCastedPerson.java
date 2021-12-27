package com.gmdb.team5.pf7project.bootstrap;

import com.gmdb.team5.pf7project.base.AbstractLogComponent;
import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Role;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class GenerateCastedPerson  extends AbstractLogComponent implements CommandLineRunner {
    private final PersonService personService;
    private final FilmService filmService;
    Random random = new Random();

    private Role generateRandomRole(){

        int index  = random.nextInt(13);
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

    @Override
    public void run(String... args) {


        Film firstFilm = filmService.findByTitle("Pacific Rim");

        filmService.addItem(firstFilm, personService.find( (long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstFilm, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstFilm, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstFilm, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.create(firstFilm);
//        logger.info("Created {} casted persons in the movie {}.", filmService.createAll(firstFilm).size(), firstFilm.getTitle());

        Film secondFilm = filmService.findByTitle("Avengers");

        filmService.addItem(secondFilm, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(secondFilm, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(secondFilm, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.create(secondFilm);
        //        logger.info("Created {} casted persons in the movie {}.", filmService.createAll(secondFilm).size(), secondFilm.getTitle());

        Film firstTVShow = filmService.findByTitle("Game of Thrones");

        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(firstTVShow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.create(firstTVShow);
//        logger.info("Created {} casted persons in the movie {}.", filmService.createAll(secondFilm).size(), secondFilm.getTitle());


        Film secondTVshow = filmService.findByTitle("Witcher");

        filmService.addItem(secondTVshow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(secondTVshow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(secondTVshow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(secondTVshow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.addItem(secondTVshow, personService.find((long) random.nextInt(10 - 1) + 1), generateRandomRole());
        filmService.create(secondTVshow);

//        logger.info("Created {} casted persons in the movie {}.", filmService.createAll(secondFilm).size(), secondFilm.getTitle());



    }
}
