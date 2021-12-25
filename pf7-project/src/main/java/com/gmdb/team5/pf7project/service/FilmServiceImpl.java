package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.*;
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
    public Film find(Long id) {
        return findLazy(id);
    }

    @Override
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

    private boolean validate(Film film) {
        return film != null && !film.getPeopleCasted().isEmpty();
    }

    private Cast newCastedPerson(Film film, Person person, Role role) {
        return Cast.builder().film(film).person(person).role(role).build();
    }

    @Override
    public void addItem(Film film, Person person, Role role) {
        if (checkNullability(film, person) || role == null) {
            return;
        }
        film.getPeopleCasted().add(newCastedPerson(film, person, role));

        logger.debug("Person[{}] added to Film[{}] as a {}", person, film, role);
    }

    @Override
    public void updateItem(Film film, Person person, Role role) {
        if (checkNullability(film, person) || role == null) {
            return;
        }

        film.getPeopleCasted().removeIf(oi -> oi.getPerson().getId().equals(person.getId()));
        film.getPeopleCasted().add(newCastedPerson(film, person, role));

        logger.debug("Person[{}] updated in Film[{}] as a {}", person, film, role);
    }

    @Override
    public void removeItem(Film film, Person person) {
        if (checkNullability(film, person)) {
            return;
        }
        film.getPeopleCasted().removeIf(oi -> oi.getPerson().getId().equals(person.getId()));

        logger.debug("Person[{}] removed from Film[{}]", person, film);
    }


// Reports Starts here!

//    @Override
//    public List<Film> findTopRatedContent(Long id) {
//        return fIlmRepository.findTopRatedContent(id);
//    }
//
//    @Override
//    public List<Film> findContentByPerson(Person person) {
//        return fIlmRepository.findContentByPerson(person);
//    }
//
//    @Override
//    public List<Film> findContentByPersonByRole(Person person, Role role) {
//        return null;
//    }
//
//    @Override
//    public List<Film> findContentByGenre(Genre genre) {
//        return null;
//    }
//
//    @Override
//    public Map<Genre, Long> findContentPerGenre() {
//        return null;
//    }
//
//    @Override
//    public Map<Integer, Map<Genre, Long>> findContentPerYearPerGenre() {
//        return null;
//    }
//
//    @Override
//    public Map<Genre, List<Film>> findContentOfPersonPerGenre(Person person) {
//        return null;
//    }
}
