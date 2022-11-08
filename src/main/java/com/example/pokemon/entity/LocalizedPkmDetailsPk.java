package com.example.pokemon.entity;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class LocalizedPkmDetailsPk implements Serializable {

    private PkmDetailsPK pkmDetailsId;
    @Column(name = "language_iso_639_1", updatable = false, insertable = false, nullable = false)
    private String langId;
}
