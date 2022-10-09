package com.example.pokemon.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class LocalizedGenerationPk implements Serializable {

    @Serial
    private static final long serialVersionUID = -8702553783633748971L;

    @Column(name = "generation_id", updatable = false, insertable = false, nullable = false)
    private Long generationId;

    @Column(name = "language_iso_639_1", updatable = false, insertable = false, nullable = false)
    @Length(min = 2, max = 2)
    private String langId;


}
