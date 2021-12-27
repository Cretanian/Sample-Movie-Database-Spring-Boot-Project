package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilmService extends BaseService<Film> {

    Film findByTitle (String title);

    void addItem(Film film, Person product, Set<Role> role);

    void updateItem(Film film, Person product, Role role);

    void removeItem(Film film, Person product);

    Film findLazy(Long id);

    List<Film> findAllLazy();

//    //first report
//    List<Film> findTopRatedContent(Long id);
//
//    //second report
//    List<Film> findContentByPerson(Person person);
//
//    //third report
//    List<Film> findContentByPersonByRole(Person person, Role role);
//
//    //fourth report
//    List<Film> findContentByGenre(Genre genre);
//
//    //fifth report
//    Map<Genre,Long> findContentPerGenre();
//
//    //sixth report
//    Map<Integer,Map<Genre,Long>> findContentPerYearPerGenre();
//
//    //seventh
//    Map<Genre,List<Film>> findContentOfPersonPerGenre(Person person);



}
