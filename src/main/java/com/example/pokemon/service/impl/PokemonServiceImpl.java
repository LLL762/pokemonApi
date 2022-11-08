package com.example.pokemon.service.impl;

import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.repo.PokemonRepo;
import com.example.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PokemonServiceImpl implements PokemonService {


    private final PokemonRepo pkmRepo;


    @Override
    public Page<Pokemon> listAll(final int itemPerPage, final int pageNumber) {

        log.info("Fetching {} pokemons, page {}", itemPerPage, pageNumber);

        return pkmRepo.findAll(
                PageRequest.of(pageNumber, itemPerPage, Sort.Direction.ASC, "number"));
    }

    @Override
    public Optional<Pokemon> findPkmByNumber(final int number) {

        log.info("Fetching pokemon nb {}", number);


        return pkmRepo.findByNumber(number);
    }

    @Override
    public Optional<Pokemon> findPkmById(final Long id) {
        return pkmRepo.findById(id);
    }

    @Override
    public Pokemon updatePkm(final Pokemon pokemon) {

        log.info("Updating pokemon: {}", pokemon.getName());

        return pkmRepo.save(pokemon);
    }

    @Override
    public Pokemon createPkm(final Pokemon pokemon) {

        log.info("Saving new pokemon: {}", pokemon.getName());

        return pkmRepo.save(pokemon);
    }

    @Override
    public boolean deletePkmById(final Long id) {
        pkmRepo.deleteById(id);
        return false;
    }


}
