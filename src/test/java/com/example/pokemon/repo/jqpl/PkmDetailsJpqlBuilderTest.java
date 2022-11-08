package com.example.pokemon.repo.jqpl;

import org.junit.jupiter.api.Test;

import static com.example.pokemon.repo.jqpl.constant.FetchLangMod.SOME;

class PkmDetailsJpqlBuilderTest {


    @Test
    void test() {

        System.out.println(new PkmDetailsJpqlBuilder()
                .selectDetails()
                .byId()
                .fetchPkm(SOME)
                .fetchGen(SOME)
                .fetchTypes(SOME)
                .build())

        ;
    }

    @Test
    void test2() {

        System.out.println(new PkmDetailsJpqlBuilder()
                .selectDetails()
                .byId()
                .fetchPkm(SOME)
                .fetchGen(SOME)
                .fetchTypes(SOME)
                .fetchLocals(SOME)
                .build())

        ;
    }


}