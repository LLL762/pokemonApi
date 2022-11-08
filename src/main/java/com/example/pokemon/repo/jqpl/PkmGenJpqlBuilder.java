package com.example.pokemon.repo.jqpl;

import static com.example.pokemon.repo.jqpl.constant.FieldsNames.GEN_LOCALS_FETCH;
import static com.example.pokemon.repo.jqpl.constant.Names.GEN;
import static com.example.pokemon.repo.jqpl.constant.Names.GEN_LOCAL;
import static com.example.pokemon.repo.jqpl.constant.QueryParam.GEN_NUM;

public class PkmGenJpqlBuilder {

    public static final String FIND_BY_ID = new JpqlBuilder()
            .select(GEN, "Generation")
            .joinLocal(GEN, GEN_LOCALS_FETCH, GEN_LOCAL)
            .where(GEN, "number", GEN_NUM, "=")
            .orderBy(GEN, "number", true)
            .build();

    public static final String FIND_BY_ID_LOCALS_ALL = new JpqlBuilder()
            .select(GEN, "Generation")
            .join(GEN, GEN_LOCALS_FETCH, GEN_LOCAL)
            .where(GEN, "number", GEN_NUM, "=")
            .orderBy(GEN, "number", true)
            .build();

    public static final String FIND_ALL = new JpqlBuilder()
            .select(GEN, "Generation")
            .joinLocal(GEN, GEN_LOCALS_FETCH, GEN_LOCAL)
            .orderBy(GEN, "number", true)
            .build();

    public static final String FIND_ALL_LOCALS_ALL = new JpqlBuilder()
            .select(GEN, "Generation")
            .join(GEN, GEN_LOCALS_FETCH, GEN_LOCAL)
            .orderBy(GEN, "number", true)
            .build();


}







