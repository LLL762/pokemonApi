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
    private Long number;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, String> pkmStatsSchema = new HashMap<>();

}
