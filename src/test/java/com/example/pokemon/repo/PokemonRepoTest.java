package com.example.pokemon.repo;

import com.example.pokemon.entity.PkmDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PokemonRepoTest {

    @Autowired
    private PokemonRepo pokemonRepo;

    @Test
    void test() {

        List<Object[]> pkmInfos = pokemonRepo.getInfos(1L, 1L, "fr");

        for (Object[] objs : pkmInfos) {
            for (Object obj : objs) {
                System.out.println(obj);
            }
        }

        System.out.println(((PkmDetails) pkmInfos.get(0)[2]).getPkmTypes());


    }

}