package com.example.pokemon.entity;


import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Getter
public class LocalizedPkmPk implements Serializable {

    @Serial
    private static final long serialVersionUID = -8702553783633748971L;
    @Column(name = "pokemon_id", updatable = false, insertable = false, nullable = false)
    private Long pkmId;

    @Column(name = "language_iso_639_1", updatable = false, insertable = false, nullable = false)
    @Length(min = 2, max = 2)
    private String langId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalizedPkmPk that = (LocalizedPkmPk) o;

        if (!pkmId.equals(that.pkmId)) return false;
        return langId.equals(that.langId);
    }

    @Override
    public int hashCode() {
        int result = pkmId.hashCode();
        result = 31 * result + langId.hashCode();
        return result;
    }
}
