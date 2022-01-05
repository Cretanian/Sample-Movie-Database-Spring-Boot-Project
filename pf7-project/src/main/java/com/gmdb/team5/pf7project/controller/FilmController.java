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

    @GetMapping(params = {"t"})
    public Film findByTitle(@RequestParam("t") String title){
        return filmService.findByTitle(title);
    }

    //export csv for all films + genre
    @GetMapping("/export")
    public void exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=people_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Film> findFilmAndGenre = filmService.findAll();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Film ID", "Title", "Description", "Release Year", "Language", "Duration", "Rating", "Genre"};
        String[] nameMapping = {"id", "title", "description", "releaseYear", "language", "duration", "rating", "genre"};

        csvWriter.writeHeader(csvHeader);

        for (Film film : findFilmAndGenre) {
            csvWriter.write(film, nameMapping);
        }

        csvWriter.close();
    }
}
