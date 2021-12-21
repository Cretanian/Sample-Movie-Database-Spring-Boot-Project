package com.gmdb.team5.pf7project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)

public class FilmTVShow extends BaseModel{

    private String title;

    private String description;

    //comeoutyear
    private Integer releaseYear;

    private String language;

    //in minutes
    private Integer duration;

    private Rating rating;

    private List<GenreOfFilmTVShow> genreOfFilmTVShow;
}
