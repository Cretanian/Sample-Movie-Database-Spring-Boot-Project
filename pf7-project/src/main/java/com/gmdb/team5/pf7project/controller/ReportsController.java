package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.domain.Genre;
import com.gmdb.team5.pf7project.domain.Person;
import com.gmdb.team5.pf7project.domain.Role;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.service.PersonService;
import com.gmdb.team5.pf7project.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController  extends AbstractController<Film>{
    private final PersonService personService;
    private final FilmService filmService;

    @Override
    protected BaseService<Film> getBaseService() {
        return filmService;
    }


   @GetMapping(params = {"num"}, headers = "action=firstReport")
    public ResponseEntity<ApiResponse<Page<Film>>> firstReport(@RequestParam("num") Integer num){
        return ResponseEntity.ok(ApiResponse.<Page<Film>>builder().data(filmService.findTopRatedFilms(num)).build());
   }

    @GetMapping(params = {"id"}, headers = "action=secondReport")
    public ResponseEntity<ApiResponse<List<Film>>> secondReport(@RequestParam("id") Long id){
        Person person = personService.find(id);
        return ResponseEntity.ok(ApiResponse.<List<Film>>builder().data(filmService.findFilmByPerson(person)).build());
    }

    @GetMapping(params = {"id","role"}, headers = "action=thirdReport")
    public ResponseEntity<ApiResponse<List<Film>>> thirdReport(@RequestParam("id") Long id, @RequestParam("role") String roleStr){
        Person person = personService.find(id);
        Role role = Role.valueOf(roleStr);
        return ResponseEntity.ok(ApiResponse.<List<Film>>builder().data(filmService.findFilmByPersonByRole(person, role)).build());
    }

    @GetMapping(params = {"genre"}, headers = "action=fourthReport")
    public ResponseEntity<ApiResponse<List<Film>>> fourthReport(@RequestParam("genre") String genreStr){
        Genre genre = Genre.valueOf(genreStr);
        return ResponseEntity.ok(ApiResponse.<List<Film>>builder().data(filmService.findFilmByGenre(genre)).build());
    }

    @GetMapping(headers = "action=fifthReport")
    public ResponseEntity<ApiResponse<Map<String, BigInteger>>> fifthReport(){
        return ResponseEntity.ok(ApiResponse.<Map<String,
                BigInteger>>builder().data(filmService.findNumberOfFilmPerGenre()).build());
    }

    @GetMapping(headers = "action=sixthReport")
    public ResponseEntity<ApiResponse<Map<Integer,Map<String,BigInteger>>>> sixthReport(){
        return ResponseEntity.ok(ApiResponse.<Map<Integer,Map<String,BigInteger>>>builder()
                .data(filmService.findFilmPerYearPerGenre()).build());
    }

    @GetMapping(params = {"id"}, headers = "action=seventhReport")
    public ResponseEntity<ApiResponse<Map<String, List<Film>>>> seventhReport(@RequestParam("id") Long id){
        Person person = personService.find(id);
        return ResponseEntity.ok(ApiResponse.<Map<String, List<Film>>>builder()
                .data(filmService.findFilmOfPersonPerGenre(person)).build());
    }
}
