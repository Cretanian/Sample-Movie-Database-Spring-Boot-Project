package com.gmdb.team5.pf7project.service;


import com.gmdb.team5.pf7project.domain.TVShowCast;
import org.springframework.data.jpa.repository.JpaRepository;

public class TVShowCastServiceImpl extends BaseServiceImpl<TVShowCast>  implements TVShowCastService {
    @Override
    public JpaRepository<TVShowCast, Long> getRepository() {
        return null;
    }
}
