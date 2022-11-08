package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
public class LocalizedPkmDetails {

    @EmbeddedId
    private LocalizedPkmDetailsPk id;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, String> pkmStats = new HashMap<>();

    @ManyToOne
    @MapsId("pkmDetailsId")
    private PkmDetails pkmDetails;

}
