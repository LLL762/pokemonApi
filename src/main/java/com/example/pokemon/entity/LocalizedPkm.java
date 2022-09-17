package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NamedEntityGraph(name = "LocalizedPkm.pokemon",
        attributeNodes = @NamedAttributeNode("pokemon")
)
public class LocalizedPkm {

    @EmbeddedId
    private LocalizedPkmPk id;

    private String name;


    @MapsId("pkmId")
    @ManyToOne(fetch = LAZY) //Bi-directional
    private Pokemon pokemon;

    @MapsId("langId")
    @ManyToOne(fetch = LAZY)
    private Language language;

}
