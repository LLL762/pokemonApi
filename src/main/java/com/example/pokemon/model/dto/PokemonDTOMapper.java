package com.example.pokemon.model.dto;

import com.example.pokemon.entity.Pokemon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PokemonDTOMapper {

    @Mapping(target = "created", source = "pokemon.created",
            dateFormat = "dd-MM-yyyy")
    PokemonDTO toDTO(Pokemon pokemon);

    @Mapping(target = "created", source = "pokemonDTO.created",
            dateFormat = "dd-MM-yyyy")
    Pokemon toEntity(PokemonDTO pokemonDTO);

    @Mapping(target = "created", source = "pokemonDTO.created",
            dateFormat = "dd-MM-yyyy")
    List<PokemonDTO> toDTO(Collection<Pokemon> pokemons);


}
