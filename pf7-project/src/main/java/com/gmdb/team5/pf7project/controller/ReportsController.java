package com.gmdb.team5.pf7project.controller;

import com.gmdb.team5.pf7project.domain.Film;
import com.gmdb.team5.pf7project.service.BaseService;
import com.gmdb.team5.pf7project.service.FilmService;
import com.gmdb.team5.pf7project.transfer.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
public class ReportsController  extends AbstractController<Film>{

    private final FilmService filmService;

    @Override
    protected BaseService<Film> getBaseService() {
        return filmService;
    }


   @GetMapping(headers = "action=firstReport")
    public ResponseEntity<ApiResponse<Page<Film>>> firstReport(){
        return ResponseEntity.ok(ApiResponse.<Page<Film>>builder().data(filmService.findTopRatedFilms(5)).build());
   }



}
