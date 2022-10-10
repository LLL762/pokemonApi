package com.example.pokemon.service.impl;

import com.example.pokemon.repo.PkmDetailsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.pokemon.repo.PkmDetailsRepo.hasId;

@Service
@RequiredArgsConstructor
public class PkmDetailsServiceImpl {

    private final PkmDetailsRepo pkmDetailsRepo;

    public void getPkmDetails(Long pkmId, Long genNum, String langIso) {

        pkmDetailsRepo.findAll(hasId(pkmId, genNum));

    }


}
