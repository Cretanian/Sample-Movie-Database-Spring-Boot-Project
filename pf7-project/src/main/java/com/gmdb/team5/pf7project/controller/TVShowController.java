package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.TVShow;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.TVShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping(params = {"title"})
    public TVShow findByTitle(@RequestParam("title") String title) {
        return tvShowService.findByTitle(title);
    }

    @GetMapping(params = {"seasons"})
    public List<TVShow> findByNumberOfSeasons(@RequestParam("seasons") Integer seasons) {
        return tvShowService.findByNumberOfSeasons(seasons);
    }

    @GetMapping(params = {"episodes"})
    public List<TVShow> findByNumberOfEpisodes(@RequestParam("episodes") Integer episodes) {
        return tvShowService.findByNumberOfEpisodes(episodes);
    }

}
