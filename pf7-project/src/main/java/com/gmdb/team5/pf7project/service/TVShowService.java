package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.TVShow;

public interface TVShowService extends BaseService<TVShow>{

    TVShow findByTitle (String title);
}
