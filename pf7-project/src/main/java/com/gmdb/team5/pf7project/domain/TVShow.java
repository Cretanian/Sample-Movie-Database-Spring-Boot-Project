package com.gmdb.team5.pf7project.domain;

import com.sun.istack.NotNull;
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
@Table(name = "TVSHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "TVSHOWS_SEQ", initialValue = 1, allocationSize = 1)
public class TVShow extends Film{

    @Column(nullable = false)
    private Integer episodes;

    @Column(nullable = false)
    private Integer seasons;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Film> Film = new HashSet<>();

}
