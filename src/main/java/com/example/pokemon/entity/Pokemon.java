package com.example.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
    @Digits(integer = 5, fraction = 2)
    private BigDecimal heightInMeter;

    @Min(value = 0, message = "Must be positive")
    @Digits(integer = 3, fraction = 3)
    private BigDecimal weightInKg;

    @URL
    private String imageUrl;

    private LocalDate created;
    private LocalDateTime lastEdit;

    @OneToMany(fetch = LAZY, mappedBy = "pokemon")
    @JsonIgnore
    @ToString.Exclude
    private Set<PkmDetails> pkmDetails = new HashSet<>();


}
