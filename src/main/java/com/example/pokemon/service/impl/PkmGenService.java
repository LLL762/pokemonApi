package com.example.pokemon.service.impl;

import com.example.pokemon.entity.Generation;
import com.example.pokemon.entity.LocalizedGeneration;
import com.example.pokemon.repo.PkmGenRepo;
import com.example.pokemon.service.IPkmGenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PkmGenService implements IPkmGenService {

    private final PkmGenRepo pkmGenRepo;


    @Override
    public Generation findByNum(Long genNum, String[] langIso) {
        return null;
    }

    @Override
    public List<Generation> findAll(String[] langIso) {
        return null;
    }

    @Override
    public Generation addGen(Generation gen) {
        return null;
    }

    @Override
    public Generation updateGen(Generation gen) {
        return null;
    }

    @Override
    public List<String> getAvailableLangs(Long genNum) {
        return null;
    }

    @Override
    public LocalizedGeneration addLocal(Long genNum, String langIso) {
        return null;
    }

    @Override
    public LocalizedGeneration updateLocal(Long genNum, String langIso) {
        return null;
    }
}
