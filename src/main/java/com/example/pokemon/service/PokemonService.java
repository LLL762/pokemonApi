package com.example.pokemon.service;

import com.example.pokemon.entity.Pokemon;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
public interface PokemonService {

    Page<Pokemon> listAll(int itemPerPage, int pageNumber);

    Optional<Pokemon> findPkmByNumber(int number);

    Optional<Pokemon> findPkmById(Long id);

    Pokemon updatePkm(Pokemon pokemon);

    Pokemon createPkm(Pokemon pokemon);


    boolean deletePkmById(Long id);


}
