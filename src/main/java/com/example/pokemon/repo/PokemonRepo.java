package com.example.pokemon.repo;

import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.repo.jqpl.constant.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.pokemon.repo.jqpl.LocalizedPkmJPQL.GET_PKM_DETAILS2;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {


    @Query(GET_PKM_DETAILS2)
    public List<PkmDetails> getInfos(@Param(QueryParam.PKM_ID) final Long pkmId,
                                     @Param(QueryParam.GEN_NUM) final Long genNum,
                                     @Param(QueryParam.LANG_ISO) final String[] langId);


    Optional<Pokemon> findByNumber(int number);

}
