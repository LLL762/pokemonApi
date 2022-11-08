package com.example.pokemon.repo.jqpl;

import org.junit.jupiter.api.Test;

import static com.example.pokemon.repo.jqpl.PkmGenJpqlBuilder.FIND_BY_ID;
import static com.example.pokemon.repo.jqpl.PkmGenJpqlBuilder.FIND_BY_ID_LOCALS_ALL;

class PkmGenJpqlBuilderTest {

    @Test
    void findAll() {
        System.out.println(FIND_BY_ID);
        System.out.println(FIND_BY_ID_LOCALS_ALL);
    }


}