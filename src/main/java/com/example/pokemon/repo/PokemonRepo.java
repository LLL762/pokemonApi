package com.example.pokemon.repo;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.entity.Pokemon;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.MapJoin;
import java.util.List;
import java.util.Optional;

import static com.example.pokemon.repo.LocalizedPkmJPQL.*;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long>, JpaSpecificationExecutor<Pokemon> {

    static Specification<Pokemon> hasLang(final String langIso) {

        return (pkm, cq, cb) -> {
            final MapJoin<Pokemon, String, LocalizedPkm> localizedPkms = pkm.joinMap("localizedPkms");

            pkm.fetch("localizedPkms", JoinType.LEFT);
            return cb.equal(localizedPkms.key(),
                    langIso);
        };
    }


    @Query(GET_PKM_DETAILS)
    List<Object[]> getInfos(@Param(PARAM_PKM_ID) Long pkmId,
                            @Param(PARAM_GEN_NUM) Long genNum,
                            @Param(PARAM_LANG_ID) String langId);


    Optional<Pokemon> findByNumber(int number);

}
