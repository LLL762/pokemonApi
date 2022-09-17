package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
@Getter
@Setter
public class Language {

    @Id
    @Column(name = "iso_639_1")
    @Length(min = 2, max = 2)
    private String lang;

    @Column(name = "name", unique = true)
    private String name;


    @PrePersist
    private void nameToLowerCase() {
        this.name = name.toLowerCase();
    }

}
