package com.gmdb.team5.pf7project.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

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
    private Integer numberOfEpisodes;

    @Column(nullable = false)
    private Integer numberOfSeasons;

//    @OneToMany(fetch = FetchType.LAZY)
//    private Set<Film> episodes = new HashSet<>();

}
