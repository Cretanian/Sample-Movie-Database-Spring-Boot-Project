package com.gmdb.team5.pf7project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Cast extends BaseModel {

//    @EmbeddedId
//    private FilmPersonKey key;


//    @MapsId("personId")
    @JoinColumn(name = "PERSON_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Person person;

//    @MapsId("filmId")
//    @JsonBackReference("castedPerson")
    @JoinColumn(name = "FILM_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Film film;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private Role role;


}
