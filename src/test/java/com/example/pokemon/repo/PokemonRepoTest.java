package com.example.pokemon.repo;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.entity.LocalizedPkmType;
import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.entity.PkmType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
class PokemonRepoTest {

    @Autowired
    private PokemonRepo pokemonRepo;


    @Test
    void test() {

//        final PkmDetails pkmInfos = pokemonRepo.getInfos(1L, 1L, "en").get();
//
//        Set<PkmType> pkmTypes = pkmInfos.getPkmTypes();
//
//        for (PkmType type : pkmTypes) {
//            for (LocalizedPkmType localType : type.getLocalizedPkmTypes().values()) {
//
//                System.out.println(localType.getName());
//            }
//        }
//
//        for (LocalizedPkm localPkm : pkmInfos.getPokemon().getLocalizedPkms().values()) {
//
//            System.out.println(localPkm.getName());
//
//        }

    }

    @Test
    void test2() {

        final List<PkmDetails> pkmInfo = pokemonRepo.getInfos(1L, 1L, "en");

        System.out.println(pkmInfo.size());
        PkmDetails pkmInfos = pkmInfo.get(0);

        Set<PkmType> pkmTypes = pkmInfos.getPkmTypes();

        for (PkmType type : pkmTypes) {
            for (LocalizedPkmType localType : type.getLocalizedPkmTypes().values()) {

                System.out.println(localType.getName());
            }
        }

        for (LocalizedPkm localPkm : pkmInfos.getPokemon().getLocalizedPkms().values()) {

            System.out.println(localPkm.getName());

        }

    }

}