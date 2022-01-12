package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/films")
public class FilmController extends AbstractController<Film> {
    private final FilmService filmService;

    @Override
    protected BaseService<Film> getBaseService() {
        return filmService;
    }

    @GetMapping(params = {"title"})
    public Film findByTitle(@RequestParam("title") String title) {
        return filmService.findByTitle(title);
    }
}
