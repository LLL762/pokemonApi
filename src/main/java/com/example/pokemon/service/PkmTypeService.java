package com.example.pokemon.service;

import com.example.pokemon.entity.LocalizedGeneration;
import com.example.pokemon.entity.PkmType;

import java.util.List;
import java.util.Optional;

public interface PkmTypeService {

    Optional<PkmType> findByid(Long id, String[] langIso);

    Optional<PkmType> findByName(String name, String langIso);

    List<PkmType> searchByName(String name, String langIso);

    List<PkmType> findAll(String[] langIso);

    PkmType addType(PkmType type);

    PkmType updateType(PkmType type);

    String[] getAvailableLangs(Long id);

    LocalizedGeneration addLocal(Long typeId, String langIso);

    LocalizedGeneration updateLocal(Long typeId, String langIso);

}
