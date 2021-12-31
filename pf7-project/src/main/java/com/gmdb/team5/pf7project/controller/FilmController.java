package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController extends AbstractController<Film> {
    private final FilmService filmService;

    @Override
    protected BaseService<Film> getBaseService() {
        return filmService;
    }

    @GetMapping(params = {"t"})
    public Film findByTitle(@RequestParam("t") String title){
        return filmService.findByTitle(title);
    }
}
