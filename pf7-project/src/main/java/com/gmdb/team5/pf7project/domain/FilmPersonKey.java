package com.gmdb.team5.pf7project.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class FilmPersonKey implements Serializable {
    @Column(name = "PERSON_ID")
    private Long personId;
    @Column(name = "FILM_ID")
    private Long filmId;
}
