package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.TVShow;

import java.util.List;

public interface TVShowService extends BaseService<TVShow>{

    TVShow findByTitle (String title);

    List<TVShow> findBySeasons (Integer seasons);

    List<TVShow> findByEpisodesBetween (Integer episodes);

}
