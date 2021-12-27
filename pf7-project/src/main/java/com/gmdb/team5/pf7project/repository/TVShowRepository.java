package com.gmdb.team5.pf7project.repository;


import com.gmdb.team5.pf7project.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow,Long> {

    TVShow findByTitle(String title);

    List<TVShow> findByNumberOfSeasons(Integer seasons);

    //range of episodes? e.g. 20 to 100
    List<TVShow> findByNumberOfEpisodes(Integer episodes);

}
