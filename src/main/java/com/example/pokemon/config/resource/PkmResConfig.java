package com.example.pokemon.config.resource;

public final class PkmResConfig {

    public static final String URL_BASE = "/pokemon";
    public static final String URL_ALL = "/all";
    public static final String PATH_VAR_BY_ID = "/{id}";


    private PkmResConfig() {
    }

    public static final class MsgSrcConfig {

        public static final String BASE = "resource.pokemon";
        public static final String ALL_OK = BASE + ".all";
        public static final String CREATED_OK = BASE + ".created";
        public static final String GET_BY_ID_OK = BASE + ".byId";

        private MsgSrcConfig() {
        }
    }


}
