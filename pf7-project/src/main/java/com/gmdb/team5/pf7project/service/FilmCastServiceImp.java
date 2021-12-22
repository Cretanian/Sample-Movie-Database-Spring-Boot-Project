package com.gmdb.team5.pf7project.service;

import com.gmdb.team5.pf7project.domain.FilmCast;
import org.springframework.data.jpa.repository.JpaRepository;


public class FilmCastServiceImp extends BaseServiceImpl<FilmCast> implements FilmCastService {
    @Override
    public JpaRepository<FilmCast, Long> getRepository() {
        return null;
    }
}
