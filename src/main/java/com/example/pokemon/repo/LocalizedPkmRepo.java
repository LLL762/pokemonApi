package com.example.pokemon.repo;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.entity.LocalizedPkmPk;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.Optional;

import static com.example.pokemon.repo.LocalizedPkmJPQL.*;


@Repository
public interface LocalizedPkmRepo extends JpaRepository<LocalizedPkm, LocalizedPkmPk> {


    //Unreadable
    @EntityGraph(value = "LocalizedPkm.pokemon")
    Optional<LocalizedPkm> findByIdPkmIdAndIdLangIdIgnoreCase(Long pkmId, String langId);


    @Query(GET_BY_PK_IGNORE_CASE)
    @QueryHints(value = {@QueryHint(name = READ_ONLY_HINT, value = "true")})
    @EntityGraph(value = "LocalizedPkm.pokemon")
    Optional<LocalizedPkm> getByPkFetchPkm(@Param(PARAM_PKM_ID) Long pkmId, @Param(PARAM_LANG_ID) String langId);

    @Query(value = GET_BY_PK_IGNORE_CASE_WITH_FALLBACK)
    @QueryHints(value = {@QueryHint(name = READ_ONLY_HINT, value = "true")})
    @EntityGraph(value = "LocalizedPkm.pokemon")
    Collection<LocalizedPkm> getByPkFetchPkmFallBack(@Param(PARAM_PKM_ID) Long pkmId,
                                                     @Param(PARAM_LANG_ID) String langId,
                                                     @Param(PARAM_FALL_BACK_LANG_ID) String fbLangId);

}
