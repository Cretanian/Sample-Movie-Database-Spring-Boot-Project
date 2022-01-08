package com.gmdb.team5.pf7project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
@Entity()
@Table(name = "CASTED_PERSON")
public class CastedPerson extends BaseModel {

    @JoinColumn(name = "PERSON_ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person person;

    @JsonBackReference("castedPerson")
    @JoinColumn(name = "FILM_ID")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Film film;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", nullable = false)
    private Role role;

}
