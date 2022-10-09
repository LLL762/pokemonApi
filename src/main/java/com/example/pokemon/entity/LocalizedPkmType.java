package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class LocalizedPkmType {

    @EmbeddedId
    private LocalizedPkmTypePk id;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Name is required")
    @Size(min = 1, max = 50, message = "At least {min} and less than {max}")
    private String name;

    @MapsId("typeId")
    @ManyToOne(fetch = LAZY)
    private PkmType pkmType;

    @MapsId("langId")
    @ManyToOne(fetch = LAZY)
    private Language language;


}
