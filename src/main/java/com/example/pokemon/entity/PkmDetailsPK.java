package com.example.pokemon.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
public class PkmDetailsPK implements Serializable {

    @Column(name = "pokemon_id", updatable = false, insertable = false, nullable = false)
    private Long pkmId;

    @Column(name = "generation_id", updatable = false, insertable = false, nullable = false)
    private Integer generationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PkmDetailsPK that = (PkmDetailsPK) o;

        if (!pkmId.equals(that.pkmId)) return false;
        return generationId.equals(that.generationId);
    }

    @Override
    public int hashCode() {
        int result = pkmId.hashCode();
        result = 31 * result + generationId.hashCode();
        return result;
    }
}
