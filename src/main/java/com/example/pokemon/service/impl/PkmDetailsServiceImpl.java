package com.example.pokemon.service.impl;

import com.example.pokemon.entity.LocalizedPkmDetails;
import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.repo.PkmDetailsRepo;
import com.example.pokemon.service.PkmDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PkmDetailsServiceImpl implements PkmDetailsService {

    private final PkmDetailsRepo pkmDetailsRepo;


    @Override
    public Optional<PkmDetails> getPkmDetails(Long pkmId, Long genNum, String[] langId) {

        return pkmDetailsRepo.findOneById(pkmId, genNum, langId);
    }


    @Override
    public Optional<PkmDetails> getAllPkmDetails(Long pkmId, Long genNum, String[] langId) {
        return pkmDetailsRepo.findOneByIdFetchDetails(pkmId, genNum, langId);
    }

    @Override
    public Optional<PkmDetails> findById(Long pkmId, Long genNum, String[] langId, boolean fetchDetails) {
        return Optional.empty();
    }

    @Override
    public Page<PkmDetails> findByGen(Long genNum, String[] langId, int itemPerPage, int pageNumber, boolean fetchDetails) {
        return null;
    }

    @Override
    public Page<PkmDetails> findByType(Long genNum, Long typeId, String[] langId, int itemPerPage, int pageNumber, boolean fetchDetails) {
        return null;
    }

    @Override
    public PkmDetails addPkmDetail(PkmDetails pkmDetails) {
        return null;
    }

    @Override
    public PkmDetails updatePkmDetail(PkmDetails pkmDetails) {
        return null;
    }

    @Override
    public LocalizedPkmDetails addLocal(LocalizedPkmDetails localPkmDetails) {
        return null;
    }

    @Override
    public LocalizedPkmDetails updateLocal(LocalizedPkmDetails localPkmDetails) {
        return null;
    }

}
