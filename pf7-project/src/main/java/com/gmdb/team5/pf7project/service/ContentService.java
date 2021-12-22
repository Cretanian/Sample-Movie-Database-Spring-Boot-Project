package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Content;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;

import java.util.List;
import java.util.Map;

public interface ContentService< FilmOrShow > extends BaseService<Content, Long> {

    List<FilmOrShow> getContentByName (String input);

    List<FilmOrShow> getContentFromReleaseYear (Integer input);

    List<FilmOrShow> getContentFromDuration (Integer max , Integer min);

    List<FilmOrShow> getTopContentFromRating (Integer input);

    List<FilmOrShow> getContentFromRating (Integer min);

    List<FilmOrShow> getContentFromPerson (Person person);

    List<FilmOrShow> getContentFromPersonRole (Person person, Role role);

    List<FilmOrShow> getContentByGenre (Genre genre);

    Map<Genre,Long> getNumberOfShowsPerGenre (); //input might be needed

    Map<Integer,Map<Genre,Long>> getNumberOfShowsPerYearPerGenre(); //Change might be needed

    Map<Genre,Long> getAllContentFromPersonPerGenre(Person person); //meeeehhhhh

}
