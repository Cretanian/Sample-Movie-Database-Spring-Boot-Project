package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.repository.TVShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return tvShowRepository.findByTitle(title);
    }


    @Override
    public List<TVShow> findByNumberOfSeasons(Integer seasons) {
        logger.trace("Retrieving number of seasons.");
        return tvShowRepository.findByNumberOfSeasons(seasons);
    }

    @Override
    public List<TVShow> findByNumberOfEpisodes(Integer episodes) {
        logger.trace("Retrieving number of episodes.");
        return tvShowRepository.findByNumberOfEpisodes(episodes);
    }
}
