package com.example.pokemon.repo;

public final class LocalizedPkmJPQL {


    public static final String PARAM_LANG_ID = "langId";
    public static final String PARAM_PKM_ID = "pkmId";

    public static final String GET_BY_PK_IGNORE_CASE =
            "SELECT pkm FROM LocalizedPkm  pkm " +
                    "WHERE pkm.id.langId = lower(:" + PARAM_LANG_ID + ")" +
                    " AND pkm.id.pkmId = :" + PARAM_PKM_ID;


    private LocalizedPkmJPQL() {
    }
}
