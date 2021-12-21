package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.FilmTVShow;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;

import java.util.List;


public class FilmTVShowServiceImpl extends BaseServiceImpl<FilmTVShow> implements FilmTVShowService{
    @Override
    public List<FilmTVShow> highRatedContent() {
        return null;
    }

    @Override
    public List<FilmTVShow> filmTVShowOfPerson(Person person) {
        return null;
    }

    @Override
    public List<FilmTVShow> filmTVShowOfPersonRole(Person person, Role role) {
        return null;
    }

    @Override
    public List<FilmTVShow> filmTVShowOfGenre(Genre genre) {
        return null;
    }

    @Override
    public List<Long> numberOfFilmTVShowPerGenre() {
        return null;
    }

    @Override
    public List<Long> numberOfFilmTVShowPerGenrePerYear() {
        return null;
    }

    @Override
    public List<FilmTVShow> filmTVShowOfPersonPerGenre(Person person) {
        return null;
    }
}
