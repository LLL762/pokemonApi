package com.example.pokemon.model.dto;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.entity.Pokemon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface LocalizedPkmDtoMapper {


    @Mapping(target = ".", source = "pokemon")
    @Mapping(target = ".", source = "id")
    LocalizedPkmDto toDTO(LocalizedPkm pkm);

    @Mapping(target = "pokemon", source = ".")
    @Mapping(target = "id", source = ".")
    LocalizedPkm toEntity(LocalizedPkmDto pkmDTO);

    @Mapping(target = ".", source = "pokemon")
    @Mapping(target = ".", source = "id")
    List<PokemonDTO> toDTO(Collection<Pokemon> pokemons);


}
