package com.example.pokemon.repo;

import com.example.pokemon.entity.Generation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static com.example.pokemon.repo.jqpl.PkmGenJpql.*;
import static com.example.pokemon.repo.jqpl.constant.QueryParam.GEN_NUM;
import static com.example.pokemon.repo.jqpl.constant.QueryParam.LANG_ISO;

public interface PkmGenRepo extends JpaRepository<Generation, Long> {

    @Query(FIND_BY_ID)
    @EntityGraph(attributePaths = {"description"})
    Optional<Generation> findById(@Param(GEN_NUM) Long genNum, @Param(LANG_ISO) List<String> langIsos);

    @Query(FIND_BY_ID_ALL_LANG)
    Optional<Generation> findById(@Param(GEN_NUM) Long genNum);

    @Query(FIND_ALL)
    List<Generation> findAll(@Param(LANG_ISO) List<String> langIsos);

    @Query(FIND_ALL_LOCALS_ALL)
    List<Generation> findAll();

}
