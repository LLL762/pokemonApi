package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
public class PkmType {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Pattern(regexp = "^#[0-9a-f]{6}$")
    private int colorHex;

    @URL
    private String iconUrl;


    @OneToMany(mappedBy = "pkmType", cascade = CascadeType.ALL, orphanRemoval = true) //Bi-directional
    @MapKey(name = "id.langId")
    @ToString.Exclude
    private Map<String, LocalizedPkmType> localizedPkmTypes = new HashMap<>();


    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "pokemon_type_weakness",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "weakness_id")
    )
    @ToString.Exclude
    private Set<PkmType> weakness = new HashSet<>();

    @ManyToMany(fetch = LAZY)
    @JoinTable(
            name = "pokemon_type_resit",
            joinColumns = @JoinColumn(name = "type_id"),
            inverseJoinColumns = @JoinColumn(name = "resist_id")
    )
    @ToString.Exclude
    private Set<PkmType> resist = new HashSet<>();


}
