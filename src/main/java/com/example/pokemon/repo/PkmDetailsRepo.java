package com.example.pokemon.repo;

import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.entity.PkmDetailsPK;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PkmDetailsRepo extends JpaRepository<PkmDetails, PkmDetailsPK>, JpaSpecificationExecutor<PkmDetails> {

    static Specification<PkmDetails> hasId(final Long pkmId, final Long genId) {
        return (pkmDetails, cq, cb) ->
                cb.and(cb.equal(pkmDetails.get("id.pkmId"), pkmId),
                        cb.equal(pkmDetails.get("id.generationId"), genId));

    }


}
