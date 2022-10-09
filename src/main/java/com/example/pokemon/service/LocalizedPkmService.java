package com.example.pokemon.service;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.entity.Pokemon;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface LocalizedPkmService {


    Page<LocalizedPkm> listAll(int itemPerPage, int pageNumber);

    Optional<LocalizedPkm> findPkmByNumber(int number);

    Optional<LocalizedPkm> findPkmById(Long id);

    Pokemon updatePkm(LocalizedPkm pokemon);

    Pokemon createPkm(LocalizedPkm pokemon);

    boolean deletePkmById(Long pkmId, String langIso);
}
