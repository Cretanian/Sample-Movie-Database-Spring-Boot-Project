package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import com.gmdb.team5.pf7project.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository fIlmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return fIlmRepository;
    }

//    @Override
//    public Film findByTitle(String title) {
//        return fIlmRepository.findAll().stream().filter(c -> c.getTitle().equals(title)).findAny().orElse(null);
//    }

    @Override
    public Film findByTitle(String title) {
        return fIlmRepository.findByTitle(title);
    }

    @Override
    public List<Film> findTopRatedContent(Long id) {
        return fIlmRepository.findTopByRating(id);
    }

    @Override
    public List<Film> findFilmByPerson(Person person) {
        return fIlmRepository.findFilmByPerson(person);
    }

    @Override
    public List<Film> findFilmByPersonByRole(Person person, Role role) {
        return null;
    }

    @Override
    public List<Film> findFilmByGenre(Genre genre) {
        return null;
    }

    @Override
    public Map<Genre, Long> findNumberOfFilmPerGenre() {
        return null;
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
