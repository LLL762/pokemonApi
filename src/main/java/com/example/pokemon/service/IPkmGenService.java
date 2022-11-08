package com.example.pokemon.service;

import com.example.pokemon.entity.Generation;
import com.example.pokemon.entity.LocalizedGeneration;

import java.util.List;

public interface IPkmGenService {

    Generation findByNum(Long genNum, String[] langIso);

    List<Generation> findAll(String[] langIso);

    Generation addGen(Generation gen);

    Generation updateGen(Generation gen);

    List<String> getAvailableLangs(Long genNum);

    LocalizedGeneration addLocal(Long genNum, String langIso);

    LocalizedGeneration updateLocal(Long genNum, String langIso);

}
