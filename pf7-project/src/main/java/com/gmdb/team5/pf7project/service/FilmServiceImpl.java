package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.*;
import com.gmdb.team5.pf7project.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService {
    private final FilmRepository fIlmRepository;

    @Override
    public JpaRepository<Film, Long> getRepository() {
        return fIlmRepository;
    }

    @Override
    @Transactional
    public Film find(Long id) {
        return findLazy(id);
    }

    @Override
    @Transactional
    public Film findLazy(Long id) {
        return fIlmRepository.findLazy(id);
    }

    @Override
    public List<Film> findAll() {
        return findAllLazy();
    }

    @Override
    public List<Film> findAllLazy() {
        return fIlmRepository.findAllLazy();
    }

    @Override
    public Film findByTitle(String title) {
        return fIlmRepository.findAll().stream().filter(c -> c.getTitle().equals(title)).findAny().orElse(null);
    }

    private boolean checkNullability(Film film, Person person) {
        if (film == null) {
            logger.warn("Film is null.");
            return true;
        }
        if (person == null) {
            logger.warn("Person is null.");
            return true;
        }
        return false;
    }


    private CastedPerson newCastedPerson(Film film, Person person, Set<Role> role) {
        return CastedPerson.builder().film(film).person(person).role(role).build();
    }

    @Override
    public void addItem(Film film, Person person, Set<Role> role) {
        if (checkNullability(film, person) || role == null) {
            return;
        }

        film.getPeopleCasted().add(newCastedPerson(film, person, role));
        logger.debug("Person[{}] added to Film[{}] as a {}", person, film, role);
    }




//Reports Start here



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
