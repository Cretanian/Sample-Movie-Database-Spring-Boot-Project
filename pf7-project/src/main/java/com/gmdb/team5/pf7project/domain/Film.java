package com.gmdb.team5.pf7project.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity()
@Table(name = "FILMS")
@SequenceGenerator(name = "idGenerator", sequenceName = "FILMS_SEQ", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Film extends BaseModel {

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 600, nullable = true)
    private String description;

    @Column(nullable = false)
    private Integer releaseYear;

    @Column(length = 30, nullable = false)
    private String language;

    @Column(nullable = true)
    private Integer duration;

    @Enumerated(EnumType.STRING)
    @Column(length = 15, nullable = false)
    private Rating rating;

    @ElementCollection(targetClass = Genre.class , fetch = FetchType.EAGER)
    @CollectionTable(
            name = "FILMGENRE",
            joinColumns = @JoinColumn(name = "FILM_ID")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE_ID")
    private Set<Genre> genre = new HashSet<>();

    @OneToMany(mappedBy = "person")
    private Set<Cast> peopleCasted = new HashSet<>();

}
