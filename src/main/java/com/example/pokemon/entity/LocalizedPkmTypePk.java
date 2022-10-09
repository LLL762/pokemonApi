package com.example.pokemon.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class LocalizedPkmTypePk implements Serializable {

    @Column(name = "type_id", updatable = false, insertable = false, nullable = false)
    private Long typeId;

    @Column(name = "language_iso_639_1", updatable = false, insertable = false, nullable = false)
    @Length(min = 2, max = 2)
    private String langId;


}
