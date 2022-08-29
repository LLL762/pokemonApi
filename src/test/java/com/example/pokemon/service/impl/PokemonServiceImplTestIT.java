package com.example.pokemon.service.impl;

import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.repo.PokemonRepo;
import com.example.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
@SpringBootTest
class PokemonServiceImplTestIT {

    @Autowired
    private PokemonRepo pkmRepo;
    @Autowired
    private PokemonService pkmService;

    @ParameterizedTest
    @CsvSource({"1,Bulbasaur", "2,Ivysaur", "3,Venusaur"})
    void find_by_an_existing_number(final int input, final String pkmName) {

        final Optional<Pokemon> pkmFound = pkmService.findPkmByNumber(input);

        assertThat(pkmFound).hasValueSatisfying(
                pkm -> assertThat(pkm.getName()).isEqualTo(pkmName));
    }
    
    @Test
    void find_by_a_not_existing_number(final int input, final String pkmName) {

        final Optional<Pokemon> pkmFound = pkmService.findPkmByNumber(input);

        assertThat(pkmFound).hasValueSatisfying(
                pkm -> assertThat(pkm.getName()).isEqualTo(pkmName));
    }


}