package com.example.pokemon.config;

public final class ResourcesUri {


    public static final String PKM_ID_PATH_VAR = "pkmId";
    public static final String GEN_NUM_PATH_VAR = "genNum";

    public static final String BASE = "/pkm-api";
    public static final String GEN = "/generations" + "/{" + GEN_NUM_PATH_VAR + "}";
    public static final String PKM = "/pokemons" + "/{" + PKM_ID_PATH_VAR + "}";

    public static final String LANG_PARAM = "lang";


    private ResourcesUri() {
    }
}
