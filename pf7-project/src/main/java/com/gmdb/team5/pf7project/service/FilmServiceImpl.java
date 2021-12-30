package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.*;
import com.gmdb.team5.pf7project.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

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
        return fIlmRepository.findLazy(id);
    }

    @Override
    public List<Film> findAll() {
        return findAllLazy();
    }

    @Override
    public List<Film> findAllLazy() {
        return fIlmRepository.findAllLazy();
    }

    @Override
    public Film findByTitle(String title) {
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




//Reports Start here



    @Override
    public Page<Film> findTopRatedFilms(Integer number) {
        return fIlmRepository.findAll( PageRequest.of(0, number, Sort.by(Sort.Direction.ASC, "rating")));
    }

    @Override
    public List<Film> findFilmByPerson(Person person) {
        return fIlmRepository.findFilmByPerson(person);
    }

    @Override
    public List<Film> findFilmByPersonByRole(Person person, Role role) {
        return fIlmRepository.findFilmByPersonByRole(person,role);
    }

    @Override
    public List<Film> findFilmByGenre(Genre genre) {
        return fIlmRepository.findFilmByGenre(genre);
    }

    @Override
    public Map<String,BigInteger> findNumberOfFilmPerGenre() {
        List<Object[]> list = fIlmRepository.findNumberOfFilmPerGenre();
        Map<String,BigInteger> myMap = new HashMap<>();

        for (Object[] obj : list) {
            myMap.put((String) obj[0], (BigInteger) obj[1]);
        }

        return myMap;
    }


    @Override
    public Map<Integer, Map<Genre, Long>> findFilmPerYearPerGenre() {
        return null;
    }

    @Override
    public Map<Genre, List<Film>> findFilmOfPersonPerGenre(Person person) {
        return null;
    }
}
