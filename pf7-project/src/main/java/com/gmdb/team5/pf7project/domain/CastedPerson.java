package com.gmdb.team5.pf7project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity()
@Table(name = "CASTED_PERSON")
public class CastedPerson extends BaseModel {

    @EmbeddedId
    private FilmPersonKey key;

    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "FILM_ID")
    private Film film;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Role role;


}
