package com.example.pokemon.service.impl;

import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.repo.PkmDetailsRepo;
import com.example.pokemon.service.PkmDetailsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PkmDetailsServiceImplTest {

    @Autowired
    private PkmDetailsRepo pkmDetailsRepo;
    @Autowired
    private PkmDetailsService pkmDetailsService;

    @Test
    void test() {

        String[] lang = {"fr"};

        Optional<PkmDetails> pkmDetails = pkmDetailsService.getAllPkmDetails(1L, 1L, lang);

        System.out.println(pkmDetails.get().getPokemon().getLocalizedPkms().get("fr").getPokemon());
    }


}