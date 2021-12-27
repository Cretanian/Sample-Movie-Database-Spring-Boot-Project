package com.gmdb.team5.pf7project.repository;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import com.gmdb.team5.pf7project.domain.CastedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

            //first report
//      @Query(value = "select top ?1 * from order by RATING desc", nativeQuery = true)
//      List<Film> findTopRatedContent(Long number);

      //sometimes it work sometimes it no work \_(^.^)_/
      //first report
      List<Film> findTopByRating(Long number);

      //second report
      @Query(value = "select f from Film f join CastedPerson o where o.person = ?1")
      List<Film> findFilmByPerson(Person person);

      @Query(value = "select f from Film f inner join f.peopleCasted c where c.role = ?1")
      List<Film> findFilmByPersonByRole(Person person, Role role);

      //fourth report
      @Query(value = "select f from Film f inner join f.genre where f.genre = ?1")
      List<Film> findFilmByGenre(Genre genre);

      //fifth report
      //where f.genre = ?1 ????!?!?!?!?
      @Query(value = "select count(f) from Film f inner join f.genre")
      Map<Genre,Integer> findNumberOfFilmPerGenre();

      //sixth report
      //where f.releaseYear = ?1 AND f.genre = ?1      ??!?!?!??!?!?!
      @Query(value = "select count(f) from Film f inner join f.genre")
      Map<Integer,Map<Long,Genre>> findFilmPerYearPerGenre();

      //seventh
      //does it need genre as well????? on joins???
      @Query(value = "select f from Film f inner join f.peopleCasted where f.peopleCasted = ?1")
      Map<Genre,List<Film>> findFilmOfPersonPerGenre(Person person);

      Film findByTitle (String title);

}
