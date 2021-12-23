package com.gmdb.team5.pf7project.repository;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FIlmRepository  extends JpaRepository<Film, Long> {
//    //first report
//    List<Film> findTopRatedContent(Long number);
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
