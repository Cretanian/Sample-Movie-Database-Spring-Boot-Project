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
public class Film extends BaseModel {

   // many to many for genre;
   private String title;

    private String description;

    private Integer releaseYear;

    private String language;
    //in minutes
    private Integer duration;

    private Rating rating;

    private List<GenreEnum> genre;

}
