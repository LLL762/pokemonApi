package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
public class Pokemon {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Min(value = 1, message = "Must be a positive integer")
    private int number;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Name is required")
    @Size(min = 1, max = 50, message = "At least {min} and less than {max}")
    private String name;

    @Min(value = 0, message = "Must be positive")
    private float heightInMeter;

    @Min(value = 0, message = "Must be positive")
    private float weightInKg;

    @URL
    private String imageUrl;

    private LocalDate created;
    private LocalDateTime lastEdit;

    @OneToMany(fetch = LAZY, mappedBy = "pokemon")
    private Set<PkmDetails> pkmDetails;


}
