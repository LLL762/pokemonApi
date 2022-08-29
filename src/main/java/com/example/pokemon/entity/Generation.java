package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
public class Generation {

    @Id
    private Integer number;

    @Column(unique = true, nullable = false)
    private String displayName;

    @Type(type = "json")
    @Column(columnDefinition = "json", nullable = false)
    private Map<String, String> pkmStatsSchema = new HashMap<>();

}
