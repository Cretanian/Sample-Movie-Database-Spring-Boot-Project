package com.gmdb.team5.pf7project.service;


import com.gmdb.team5.pf7project.domain.Content;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;

import java.util.List;
import java.util.Map;

public abstract class ContentServiceImpl<FilmOrShow extends Content> extends BaseServiceImpl<Content>
        implements ContentService<FilmOrShow> {

    @Override
    public List<FilmOrShow> getContentByName(String input) {
        return null;
    }

    @Override
    public List<FilmOrShow> getContentFromReleaseYear(Integer input) {
        return null;
    }

    @Override
    public List<FilmOrShow> getContentFromDuration(Integer max, Integer min) {
        return null;
    }

    @Override
    public List<FilmOrShow> getTopContentFromRating(Integer input) {
        return null;
    }

    @Override
    public List<FilmOrShow> getContentFromRating(Integer min) {
        return null;
    }

    @Override
    public List<FilmOrShow> getContentFromPerson(Person person) {
        return null;
    }

    @Override
    public List<FilmOrShow> getContentFromPersonRole(Person person, Role role) {
        return null;
    }

    @Override
    public List<FilmOrShow> getContentByGenre(Genre genre) {
        return null;
    }

    @Override
    public Map<Genre, Long> getNumberOfShowsPerGenre() {
        return null;
    }

    @Override
    public Map<Integer, Map<Genre, Long>> getNumberOfShowsPerYearPerGenre() {
        return null;
    }

    @Override
    public Map<Genre, Long> getAllContentFromPersonPerGenre(Person person) {
        return null;
    }
}
