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
public class Genre extends BaseModel {

    private GenreEnum genre;

    //many to many for film??
    private List<Film> film;
    //many to many for tvshow??
    private List<TVShow> tvShow;
}
