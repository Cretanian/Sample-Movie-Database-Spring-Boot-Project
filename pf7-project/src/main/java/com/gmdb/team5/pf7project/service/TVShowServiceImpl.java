package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TVShowServiceImpl extends BaseServiceImpl<TVShow> implements TVShowService{
    private final TVShowRepository tvShowRepository;

    @Override
    public JpaRepository<TVShow, Long> getRepository() {
        return tvShowRepository;
    }


    @Override
    public TVShow findByTitle(String title) {
        return null;
    }
}
