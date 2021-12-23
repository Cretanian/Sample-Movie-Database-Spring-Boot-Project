package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import com.gmdb.team5.pf7project.repository.FIlmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FIlmRepository fIlmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return fIlmRepository;
    }

    @Override
    public List<Film> findTopRatedContent(Long id) {
        return null;
    }

    @Override
    public List<Film> findContentByPerson(Person person) {
        return null;
    }

    @Override
    public List<Film> findContentByPersonByRole(Person person, Role role) {
        return null;
    }

    @Override
    public List<Film> findContentByGenre(Genre genre) {
        return null;
    }

    @Override
    public Map<Genre, Long> findContentPerGenre() {
        return null;
    }

    @Override
    public Map<Integer, Map<Genre, Long>> findContentPerYearPerGenre() {
        return null;
    }

    @Override
    public Map<Genre, List<Film>> findContentOfPersonPerGenre(Person person) {
        return null;
    }
}
