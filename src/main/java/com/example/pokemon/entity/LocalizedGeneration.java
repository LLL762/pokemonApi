package com.example.pokemon.entity;

import com.example.pokemon.model.AppJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NamedEntityGraph(
        name = "LocalizedGeneration.description",
        attributeNodes = @NamedAttributeNode("description")
)
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
    @JsonView(AppJsonView.projection.class)
    private String displayName;

    @Lob
    @Basic(fetch = LAZY)
    private String description;

}
