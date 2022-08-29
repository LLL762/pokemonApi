package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = IDENTITY)

    private Long id;
    private String name;

    private int height;
    private int weight;

    private String iconUrl;
   
    private LocalDate created;
    private LocalDateTime lastEdit;

    @OneToMany
    private Set<Pokemon> evolutions = new HashSet<>();

}
