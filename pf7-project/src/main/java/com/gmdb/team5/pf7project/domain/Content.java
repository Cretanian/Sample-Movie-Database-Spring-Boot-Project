package com.gmdb.team5.pf7project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@MappedSuperclass
public class Content extends BaseModel {

    private String title;

    private String description;

    private Integer releaseYear;

    private String language;

    //in minutes
    private Integer duration;

    private Rating rating;
}
