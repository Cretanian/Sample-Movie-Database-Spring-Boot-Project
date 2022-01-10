package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.*;
import com.gmdb.team5.pf7project.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.*;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository fIlmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return fIlmRepository;
    }

    @Override
    @Transactional
    public Film find(Long id) {
        return findLazy(id);
    }

    @Override
    @Transactional
    public Film findLazy(Long id) {
        logger.trace("Retrieving film with id {}.",id);
        return fIlmRepository.findLazy(id);
    }

    @Override
    public List<Film> findAll() {
        return findAllLazy();
    }

    @Override
    public List<Film> findAllLazy() {
        logger.trace("Retrieving all films.");
        return fIlmRepository.findAllLazy();
    }

    @Override
    public Film findByTitle(String title) {
        logger.trace("Retrieving film with title '{}'.",title);
        return fIlmRepository.findAll().stream().filter(c -> c.getTitle().equals(title)).findAny().orElse(null);
    }

    private boolean checkNullability(Film film, Person person) {
        if (film == null) {
            logger.warn("Film is null.");
            return true;
        }
        if (person == null) {
            logger.warn("Person is null.");
            return true;
        }
        return false;
    }

    private CastedPerson newCastedPerson(Film film, Person person, Role role) {

        return CastedPerson.builder().film(film).person(person).role(role).build();
    }

    @Override
    public void addItem(Film film, Person person, Role role) {
        if (checkNullability(film, person) || role == null) {
            return;
        }

        film.getPeopleCasted().add(newCastedPerson(film, person, role));
        logger.debug("Person[{}] added to Film[{}] as a {}", person, film, role);
    }

    public List<Object[]> findAllFilmGenre(){
        return fIlmRepository.findAllFilmGenre();
    }

    public List<Object[]> findAllCastedPeople(){
        return fIlmRepository.findAllCastedPeople();
    }



//Reports implementation starts here

    @Override
    public Page<Film> findTopRatedFilms(Integer number) {
        logger.debug("Retrieving top {} rated content.",number);
        return fIlmRepository.findAll( PageRequest.of(0, number, Sort.by(Sort.Direction.ASC, "rating")));
    }

    @Override
    public List<Film> findFilmByPersonExt(Person person) {
        logger.debug("Retrieving content associated with person {}.",person);
        return fIlmRepository.findFilmByPerson(person);
    }

    @Override
    public List<Film> findFilmByPerson(Person person) {
        List<Film> filmList = findFilmByPersonExt(person);
        for(Film f : filmList)
            f.setPeopleCasted(null);

        return filmList;
    }

    @Override
    public List<Film> findFilmByPersonByRoleExt(Person person, Role role) {
        logger.debug("Retrieving content associated with person {} for role {}.",person,role);
        return fIlmRepository.findFilmByPersonByRole(person,role);
    }

    @Override
    public List<Film> findFilmByPersonByRole(Person person, Role role) {
        List<Film> filmList = findFilmByPersonByRoleExt(person,role);
        for(Film f : filmList)
            f.setPeopleCasted(null);
        return filmList;
    }

    @Override
    public List<Film> findFilmByGenreExt(Genre genre) {
        logger.debug("Retrieving content for genre {}.",genre);
        return fIlmRepository.findFilmByGenre(genre);
    }

    @Override
    public List<Film> findFilmByGenre(Genre genre) {
        List<Film> filmList = findFilmByGenreExt(genre);
        for(Film f : filmList)
            f.setPeopleCasted(null);
        return filmList;
    }

    @Override
    public Map<String,BigInteger> findNumberOfFilmPerGenre() {
        logger.debug("Retrieving number of content for all genre.");
        List<Object[]> list = fIlmRepository.findNumberOfFilmPerGenre();
        Map<String,BigInteger> myMap = new HashMap<>();

        for (Object[] obj : list) {
            myMap.put((String) obj[0], (BigInteger) obj[1]);
        }
        return myMap;
    }

    @Override
    public Map<Integer, Map<String, BigInteger>> findFilmPerYearPerGenre() {
        logger.debug("Retrieving number of content for all genre per year.");
        List<Object[]> list = fIlmRepository.findFilmPerYearPerGenre();
        Map<String,BigInteger> myMap1 = new HashMap<>();
        Map<Integer,Map<String,BigInteger>> myMap = new HashMap<>();
        for (Object[] obj : list) {
            myMap1.put((String) obj[1], (BigInteger) obj[2]);
            myMap.put((Integer)obj[0],myMap1);
        }
             return myMap;
    }

    Film createListOfFilm(Object[] obj){
        Film film = new Film();

        film.setId( ((BigInteger)obj[1]).longValue());
        film.setDescription((String) obj[2]);
        film.setDuration((Integer) obj[3]);
        film.setLanguage((String) obj[4]);
        film.setRating(Rating.valueOf(obj[5].toString()));
        film.setReleaseYear((Integer) obj[6]);
        film.setTitle((String) obj[7]);

        return film;
    }

    @Override
    public Map<String, List<Film>> findFilmOfPersonPerGenre(Person person) {
        logger.debug("Retrieving content associated with person {} organized by genre.",person);
        List<Object[]> list = fIlmRepository.findFilmOfPersonPerGenre(person);
        Map<String, List<Film>> myMap = new HashMap<>();
        List<Film> newFilmList = new ArrayList<>();

        String genre = null;
        BigInteger id=null;
        for (Object[] obj : list) {

            if(genre == null) {
                genre = (String) obj[0];
                id = (BigInteger) obj[1];
                newFilmList.add(createListOfFilm(obj));
            } else {
                if (genre.equals(obj[0])) {
                    if(id  != obj[1]){
                        id = (BigInteger) obj[1];
                        newFilmList.add(createListOfFilm(obj));
                    }
                } else {
                    myMap.put(genre, newFilmList);
                    genre = (String) obj[0];
                    id = (BigInteger) obj[1];
                    newFilmList = new ArrayList<>();
                    newFilmList.add(createListOfFilm(obj));
                }
            }

        }
        myMap.put(genre, newFilmList);
        return myMap;
    }
}
