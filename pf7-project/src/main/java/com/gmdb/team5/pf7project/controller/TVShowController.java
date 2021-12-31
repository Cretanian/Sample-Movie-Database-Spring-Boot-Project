package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tvshows")
public class TVShowController extends AbstractController<TVShow> {
    private final TVShowService tvShowService;

    @Override
    protected BaseService<TVShow> getBaseService() {
        return tvShowService;
    }

    @GetMapping(params = {"t"})
    public TVShow findByTitle(@RequestParam("t") String title) {
        return tvShowService.findByTitle(title);
    }

    @GetMapping(params = {"s"})
    public List<TVShow> findByNumberOfSeasons(@RequestParam("s") Integer seasons) {
        return tvShowService.findByNumberOfSeasons(seasons);
    }

    @GetMapping(params = {"e"})
    public List<TVShow> findByNumberOfEpisodes(@RequestParam("e") Integer episodes) {
        return tvShowService.findByNumberOfEpisodes(episodes);
    }
}
