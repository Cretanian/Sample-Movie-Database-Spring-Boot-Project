package com.gmdb.team5.pf7project.repository;


import com.gmdb.team5.pf7project.domain.TVShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TVShowRepository extends JpaRepository<TVShow,Long> {
}
