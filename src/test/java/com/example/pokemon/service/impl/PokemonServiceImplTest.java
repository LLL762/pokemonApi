package com.example.pokemon.service.impl;

import com.example.pokemon.entity.Pokemon;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class PokemonServiceImplTest {

    @Autowired
    private PokemonServiceImpl pkmService;


    @Test
    void getPkmInfos() {

        Optional<Pokemon> pkmInfos = pkmService.getPkmInfos(1L, "en");

        System.out.println(pkmInfos.get().getLocalizedPkms());
    }
}