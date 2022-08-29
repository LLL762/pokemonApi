package com.example.pokemon.service.impl;

import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.repo.PokemonRepo;
import com.example.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepo pkmRepo;


    @Override
    public Page<Pokemon> listAll(int itemPerPage, int pageNumber) {


        return pkmRepo.findAll(
                PageRequest.of(itemPerPage, pageNumber));


    }

    @Override
    public Optional<Pokemon> findPkmByNumber(final int number) {
        return pkmRepo.findByNumber(number);
    }
}
