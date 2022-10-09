package com.example.pokemon.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class PkmDetailsPK implements Serializable {


    @Column(name = "pokemon_id", updatable = false, insertable = false, nullable = false)
    private Long pkmId;

    @Column(name = "generation_id", updatable = false, insertable = false, nullable = false)
    private Long generationId;


}
