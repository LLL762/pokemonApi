package com.example.pokemon.repo.jqpl;

public final class PkmGenJpql {

    public static final String FIND_BY_ID = """           
            SELECT DISTINCT pkmGen FROM Generation pkmGen
            LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal
            WHERE pkmGenLocal.id.langId IN :langIso
             AND pkmGen.number = :genNb
            ORDER BY pkmGen.number ASC
                        """;

    public static final String FIND_BY_ID_ALL_LANG = """
            SELECT DISTINCT pkmGen FROM Generation pkmGen
            LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal
            WHERE pkmGen.number = :genNb
            ORDER BY pkmGen.number ASC
                        """;
    public static final String FIND_ALL = """
            SELECT DISTINCT pkmGen FROM Generation pkmGen
            LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal
            WHERE pkmGenLocal.id.langId IN :langIso
            ORDER BY pkmGen.number ASC
            """;

    public static final String FIND_ALL_LOCALS_ALL = """
            SELECT DISTINCT pkmGen FROM Generation pkmGen
            LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal
            ORDER BY pkmGen.number ASC
            """;


    private PkmGenJpql() {
    }
}
