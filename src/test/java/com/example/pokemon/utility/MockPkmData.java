package com.example.pokemon.utility;

import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.model.dto.PokemonDTO;

import java.util.List;

public interface MockPkmData {
    Pokemon createPkm();

    PokemonDTO createPkmDTO();

    List<Pokemon> createPkmList(int listSize);

    List<PokemonDTO> createPkmDTOList(int listSize);
}
