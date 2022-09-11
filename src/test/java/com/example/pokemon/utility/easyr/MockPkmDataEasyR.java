package com.example.pokemon.utility.easyr;

import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.model.dto.PokemonDTO;
import com.example.pokemon.utility.MockPkmData;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;

import java.util.List;

public class MockPkmDataEasyR implements MockPkmData {

    private static final EasyRandomParameters DEFAULT_EASY_R_PARAM = EasyRandomConfig.getDefault();

    private final EasyRandom generator = new EasyRandom(DEFAULT_EASY_R_PARAM);

    @Override
    public Pokemon createPkm() {

        return generator.nextObject(Pokemon.class);
    }

    @Override
    public PokemonDTO createPkmDTO() {

        return generator.nextObject(PokemonDTO.class);
    }

    @Override
    public List<Pokemon> createPkmList(final int listSize) {

        return generator.objects(Pokemon.class, listSize)
                .toList();
    }

    @Override
    public List<PokemonDTO> createPkmDTOList(final int listSize) {

        return generator.objects(PokemonDTO.class, listSize)
                .toList();
    }


}
