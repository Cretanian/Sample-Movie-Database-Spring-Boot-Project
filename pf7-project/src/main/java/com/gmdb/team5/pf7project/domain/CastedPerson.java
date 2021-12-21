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

public class CastedPerson extends BaseModel{

    private Person person;

    private CastInfo CastInfo;

    private Role role;
}
