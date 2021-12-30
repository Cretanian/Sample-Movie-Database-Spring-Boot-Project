package com.gmdb.team5.pf7project.repository;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findByTitle (String title);


    @Query(value = "select o from Film o join fetch o.peopleCasted where o.id = ?1")
    Film findLazy(Long id);

    @Query(value = "select distinct o from Film o join fetch o.peopleCasted")
    List<Film> findAllLazy();


    //Reports Start here.

    //first report


    //second report
    @Query("select f from Film f join f.peopleCasted p where p.person = ?1")
    List<Film> findFilmByPerson(Person person);

    //third report

    @Query("select f from Film f inner join f.peopleCasted p where p.person = :person AND p.role = :role")
    List<Film> findFilmByPersonByRole(@Param("person") Person person,@Param("role") Role role);

    //fourth report
    //done
    @Query("select f from Film f inner join f.genre g where g = :genre")
    List<Film> findFilmByGenre(Genre genre);

    //fifth report

    @Query(value = "SELECT FILMGENRE.GENRE_ID, COUNT(FILMGENRE.FILM_ID) FROM FILMGENRE GROUP BY FILMGENRE.GENRE_ID", nativeQuery = true)
    List<Object[]> findNumberOfFilmPerGenre();
    
    //sixth report
    //where f.releaseYear = ?1 AND f.genre = ?1      ??!?!?!??!?!?!
    @Query(value = "Select f.RELEASEYEAR, fg.GENRE_ID, COUNT(fg.FILM_ID)\n" +
            "From FILMGENRE fg\n" +
            "         JOIN FILMS f on fg.FILM_ID = f.ID GROUP BY f.RELEASEYEAR,fg.GENRE_ID", nativeQuery = true)
   List<Object[]>findFilmPerYearPerGenre();

    //seventh
    //does it need genre as well????? on joins???
    @Query("select f from Film f inner join f.peopleCasted where f.peopleCasted = ?1")
    Map<Genre,List<Film>> findFilmOfPersonPerGenre(Person person);

}
