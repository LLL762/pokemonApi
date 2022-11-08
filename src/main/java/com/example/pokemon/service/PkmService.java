package com.example.pokemon.service;

import com.example.pokemon.entity.LocalizedPkm;
import com.example.pokemon.entity.LocalizedPkmDetails;
import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.entity.Pokemon;

import java.util.List;
import java.util.Optional;

public interface PkmService {

    Optional<Pokemon> findById(Long id, String[] langId);

    Optional<Pokemon> findByName(String name, String langId);

    List<Pokemon> findByNum(int num, String[] langId);

    List<Pokemon> searchByName(String name, String langId);

    PkmDetails addPkm(Pokemon pokemon);

    PkmDetails updatePkm(Pokemon pokemon);

    LocalizedPkmDetails addLocal(LocalizedPkm localPkm);

    LocalizedPkmDetails updateLocal(LocalizedPkm localPkm);

    List<String> getAvailableLang(Long id);


}
