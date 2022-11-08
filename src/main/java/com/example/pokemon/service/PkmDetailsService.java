package com.example.pokemon.service;

import com.example.pokemon.entity.LocalizedPkmDetails;
import com.example.pokemon.entity.PkmDetails;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PkmDetailsService {
    Optional<PkmDetails> getPkmDetails(Long pkmId, Long genNum, String[] langId);

    Optional<PkmDetails> getAllPkmDetails(Long pkmId, Long genNum, String[] langId);

    Optional<PkmDetails> findById(Long pkmId, Long genNum, String[] langId, boolean fetchDetails);

    Page<PkmDetails> findByGen(Long genNum, String[] langId, int itemPerPage, int pageNumber, boolean fetchDetails);

    Page<PkmDetails> findByType(Long genNum, Long typeId, String[] langId, int itemPerPage, int pageNumber, boolean fetchDetails);

    PkmDetails addPkmDetail(PkmDetails pkmDetails);

    PkmDetails updatePkmDetail(PkmDetails pkmDetails);

    LocalizedPkmDetails addLocal(LocalizedPkmDetails localPkmDetails);

    LocalizedPkmDetails updateLocal(LocalizedPkmDetails localPkmDetails);

}
