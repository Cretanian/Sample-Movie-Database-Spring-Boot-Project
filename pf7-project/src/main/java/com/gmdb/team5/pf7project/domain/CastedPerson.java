package com.gmdb.team5.pf7project.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Person person;

    @JsonBackReference("castedPerson")
    @JoinColumn(name = "FILM_ID")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Film film;


    @ElementCollection(targetClass = Role.class , fetch = FetchType.EAGER)
    @CollectionTable(
            name = "PERSON_ROLE",
            joinColumns = @JoinColumn(name = "CASTED_PERSON_ID")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_ID", nullable = false)
    private Set<Role> role = new HashSet<>();

}
