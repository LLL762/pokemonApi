package com.example.pokemon.entity;


import com.example.pokemon.model.AppJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
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
    @JsonView(AppJsonView.projection.class)
    private PkmDetailsPK id;

    @ManyToOne(fetch = LAZY)
    @MapsId("generationId")
    @JsonView(AppJsonView.projection.class)
    private Generation generation;

    @ManyToOne(fetch = LAZY)
    @MapsId("pkmId")
    private Pokemon pokemon;

    @ManyToMany(fetch = LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    @Length(min = 1, max = 3, message = "{min} types minimum and {max} maximum")
    private Set<PkmType> pkmTypes = new HashSet<>();

    @OneToMany(fetch = LAZY, mappedBy = "pkmDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "id.langId")
    private Map<String, LocalizedPkmDetails> pkmDetailsLocals = new HashMap<>();


}
