package com.gmdb.team5.pf7project.service;


import com.gmdb.team5.pf7project.domain.FilmTVShow;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;

import java.util.List;

public interface FilmTVShowService extends BaseService<FilmTVShow, Long> {

    List<FilmTVShow> highRatedContent();

    List<FilmTVShow> filmTVShowOfPerson(Person person);

    List<FilmTVShow> filmTVShowOfPersonRole(Person person, Role role);

    List<FilmTVShow> filmTVShowOfGenre(Genre genre);

    List<Long> numberOfFilmTVShowPerGenre();

    List<Long> numberOfFilmTVShowPerGenrePerYear();

    List<FilmTVShow> filmTVShowOfPersonPerGenre(Person person);
}
