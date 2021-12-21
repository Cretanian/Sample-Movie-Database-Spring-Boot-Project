package com.gmdb.team5.pf7project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Person extends BaseModel{

    private String firstName;

    private String lastName;

    //date of birth
    private Integer DOB;

    private String country;

    private Boolean isAlive;

}
