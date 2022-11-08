package com.example.pokemon.entity;

import com.example.pokemon.model.AppJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Generation {

    @Id
    @JsonView(AppJsonView.projection.class)
    private Long number;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, String> pkmStatsSchema = new HashMap<>();

    @OneToMany(fetch = LAZY, mappedBy = "generation", cascade = CascadeType.ALL, orphanRemoval = true) //Bi-directional
    @MapKey(name = "id.langId")
    @JsonView(AppJsonView.projection.class)
    private Map<String, LocalizedGeneration> genLocals = new HashMap<>();

}
