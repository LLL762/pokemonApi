package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
    private Integer id;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "Name is required")
    @Size(min = 1, max = 50, message = "At least {min} and less than {max}")
    private String name;

    @Column(nullable = false)
    @Pattern(regexp = "^#[0-9a-f]{8}$")
    private int colorHex;

    @URL
    private String iconUrl;

    @Basic(fetch = LAZY)
    @Lob
    @Size(max = 2000, message = "Less than {max}")
    @ToString.Exclude
    private String description;


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
