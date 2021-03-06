package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import org.springframework.data.domain.Page;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilmService extends BaseService<Film> {

    Film findByTitle (String title);

    void addItem(Film film, Person product, Role role);

    Film findLazy(Long id);

    List<Film> findAllLazy();

    List<Object[]> findAllFilmGenre();

    List<Object[]> findAllCastedPeople();


    //first report
    Page<Film> findTopRatedFilms(Integer number);

    //second report
    List<Film> findFilmByPersonExt(Person person);

    List<Film> findFilmByPerson(Person person);

    //third report
    List<Film> findFilmByPersonByRoleExt(Person person, Role role);

    List<Film> findFilmByPersonByRole(Person person, Role role);

    //fourth report
    List<Film> findFilmByGenreExt(Genre genre);

    List<Film> findFilmByGenre(Genre genre);

    //fifth report
    Map<String, BigInteger> findNumberOfFilmPerGenre();

    //sixth report
    Map<Integer,Map<String,BigInteger>> findFilmPerYearPerGenre();

    //seventh
    Map<String, List<Film>> findFilmOfPersonPerGenre(Person person);



}
