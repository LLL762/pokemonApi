package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class LocalizedGeneration {

    @EmbeddedId
    private LocalizedGenerationPk id;

    @MapsId("generationId")
    @ManyToOne(fetch = LAZY)
    private Generation generation;

    @MapsId("langId")
    @ManyToOne(fetch = LAZY)
    private Language language;


    @Column(unique = true, nullable = false)
    private String displayName;
}
