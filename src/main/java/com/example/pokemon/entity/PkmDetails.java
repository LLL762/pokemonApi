package com.example.pokemon.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

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
    private PkmDetailsPK pk;

    @Type(type = "json")
    @Column(columnDefinition = "json", nullable = false)
    private Map<String, String> pkmStats = new HashMap<>();

    @ManyToOne(fetch = LAZY)
    @MapsId("generationId")
    private Generation generation;

    @ManyToOne(fetch = LAZY)
    @MapsId("pkmId")
    private Pokemon pokemon;

    @ManyToMany(fetch = LAZY)
    @JoinColumn(name = "type_id")
    private Set<PkmType> pkmTypes = new HashSet<>();


}
