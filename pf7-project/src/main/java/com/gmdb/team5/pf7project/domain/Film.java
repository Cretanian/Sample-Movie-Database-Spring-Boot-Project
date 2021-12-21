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
public class Film extends Content {

   // many to many for genre;

    private Boolean bestPictureOscar;

    private List<Genre> genre;

}
