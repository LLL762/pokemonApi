package com.example.pokemon.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class PkmDetails {

    @EmbeddedId
    private PkmDetailsPK id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    @Basic(fetch = LAZY)
    private Map<String, String> pkmStats = new HashMap<>();

    @ManyToOne(fetch = LAZY)
    @MapsId("generationId")
    private Generation generation;

    @ManyToOne(fetch = LAZY)
    @MapsId("pkmId")
    private Pokemon pokemon;

    @ManyToMany(fetch = LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    @Length(min = 1, max = 3, message = "{min} types minimum and {max} maximum")
    private Set<PkmType> pkmTypes = new HashSet<>();


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "evolution_from_id")
    private Pokemon evolutionFrom;


}
