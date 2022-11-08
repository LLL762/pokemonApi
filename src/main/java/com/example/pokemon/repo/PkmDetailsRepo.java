package com.example.pokemon.repo;

import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.entity.PkmDetailsPK;
import com.example.pokemon.repo.jqpl.constant.QueryParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

import static com.example.pokemon.repo.jqpl.PkmDetailsJpql.*;


public interface PkmDetailsRepo extends JpaRepository<PkmDetails, PkmDetailsPK> {
    @Query(FIND_ONE_BY_ID)
    Optional<PkmDetails> findOneById(@Param(QueryParam.PKM_ID) final Long pkmId,
                                     @Param(QueryParam.GEN_NUM) final Long genNum,
                                     @Param(QueryParam.LANG_ISO) final String[] langId);

    @Query(FIND_ONE_BY_ID_ALL_LANG)
    Optional<PkmDetails> findOneById(@Param(QueryParam.PKM_ID) final Long pkmId,
                                     @Param(QueryParam.GEN_NUM) final Long genNum);

    @Query(FIND_ONE_BY_ID_FETCH_ALL_DETAILS)
    Optional<PkmDetails> findOneByIdFetchDetails(@Param(QueryParam.PKM_ID) final Long pkmId,
                                                 @Param(QueryParam.GEN_NUM) final Long genNum,
                                                 @Param(QueryParam.LANG_ISO) final String[] langId);

    @Query(FIND_ONE_BY_ID_FETCH_ALL_DETAILS_ALL_LANG)
    Optional<PkmDetails> findOneByIdFetchDetails(@Param(QueryParam.PKM_ID) final Long pkmId,
                                                 @Param(QueryParam.GEN_NUM) final Long genNum);


}
