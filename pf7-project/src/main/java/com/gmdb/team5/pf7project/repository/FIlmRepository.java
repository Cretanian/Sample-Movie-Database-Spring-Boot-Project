package com.gmdb.team5.pf7project.repository;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface FIlmRepository  extends JpaRepository<Film, Long> {

    Film findByTitle (String title);

    //Fix the above SQL commands here is an error 99% sure

    @Query(value = "select o from FILMS o join CASTED_PERSON where o.id = ?1", nativeQuery = true)
    Film findLazy(Long id);

    @Query(value = "select distinct o from FILMS o join fetch o.orderItems", nativeQuery = true)
    List<Film> findAllLazy();



//    //first report
//      @Query(value = "select top ?1 * from FILMS order by RATING desc", nativeQuery = true)
//      List<Film> findTopRatedContent(Long number);
//
//      //second report
//      @Query(value = "select f from FILMS f join Casted_Person o where o.person_id = ?1.id",nativeQuery = true)
//      List<Film> findContentByPerson(Person person);

//    //third report
//    List<Film> findContentByPersonByRole(Person person, Role role);
//
//    //fourth report
//    List<Film> findContentByGenre(Genre genre);
//
//    //fifth report
//    Map<Genre,Long> findContentPerGenre();
//
//    //sixth report
//    Map<Integer,Map<Genre,Long>> findContentPerYearPerGenre();
//
//    //seventh
//    Map<Genre,List<Film>> findContentOfPersonPerGenre(Person person);


}
