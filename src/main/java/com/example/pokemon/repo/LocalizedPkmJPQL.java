package com.example.pokemon.repo;

public final class LocalizedPkmJPQL {


    public static final String READ_ONLY_HINT = org.hibernate.jpa.QueryHints.HINT_READONLY;
    public static final String PARAM_LANG_ID = "langId";
    public static final String PARAM_FALL_BACK_LANG_ID = "fallBackLangId";
    public static final String PARAM_PKM_ID = "pkmId";

    public static final String GET_BY_PK_IGNORE_CASE = "SELECT pkm FROM LocalizedPkm  pkm " +
            "WHERE pkm.id.pkmId = :" + PARAM_PKM_ID +
            " AND pkm.id.langId = lower(:" + PARAM_LANG_ID + ")";


    public static final String GET_BY_PK_IGNORE_CASE_WITH_FALLBACK = "SELECT pkm FROM LocalizedPkm  pkm " +
            "WHERE pkm.id.pkmId = :" + PARAM_PKM_ID + " " +
            "AND(" +
            "   pkm.id.langId = lower(:" + PARAM_LANG_ID + ") " +
            "   OR " +
            "   pkm.id.langId = lower(:" + PARAM_FALL_BACK_LANG_ID + ")" +
            ")";


    private LocalizedPkmJPQL() {
    }
}
