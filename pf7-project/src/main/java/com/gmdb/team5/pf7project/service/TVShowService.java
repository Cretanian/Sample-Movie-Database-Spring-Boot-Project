package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.TVShow;

import java.util.List;

public interface TVShowService extends BaseService<TVShow>{

    TVShow findByTitle (String title);

    List<TVShow> findByNumberOfSeasons (Integer seasons);

    List<TVShow> findByNumberOfEpisodes (Integer episodes);

}
