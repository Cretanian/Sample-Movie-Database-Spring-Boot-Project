package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilmService extends BaseService<Film> {

    Film findByTitle (String title);

    void addItem(Film film, Person product, Role role);

    Film findLazy(Long id);

    List<Film> findAllLazy();


    //first report
    Page<Film> findTopRatedFilms(Integer number);

    //second report
    List<Film> findFilmByPerson(Person person);

    //third report
    List<Film> findFilmByPersonByRole(Person person, Role role);

    //fourth report
    List<Film> findFilmByGenre(Genre genre);

    //fifth report
    List<Object[]> findNumberOfFilmPerGenre();

    //sixth report
    Map<Integer,Map<Genre,Long>> findFilmPerYearPerGenre();

    //seventh
    Map<Genre,List<Film>> findFilmOfPersonPerGenre(Person person);


}
