package com.example.pokemon.repo.jqpl;

import com.example.pokemon.repo.jqpl.constant.QueryParam;

public final class LocalizedPkmJPQL {


    public static final String READ_ONLY_HINT = org.hibernate.jpa.QueryHints.HINT_READONLY;
    public static final String PARAM_LANG_ID = "langId";

    public static final String PARAM_GEN_NUM = "genNum";
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

    public static final String GET_PKM_DETAILS2 = """
            SELECT DISTINCT pkmDetails FROM PkmDetails pkmDetails
              LEFT JOIN FETCH pkmDetails.pokemon pkm
              LEFT JOIN FETCH pkm.localizedPkms localPkm
              LEFT JOIN FETCH pkmDetails.generation pkmGen
              LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal
              LEFT JOIN FETCH pkmDetails.pkmTypes pkmType
              LEFT JOIN FETCH pkmType.localizedPkmTypes localPkmType
              WHERE pkmDetails.id.pkmId = :pkmId
              AND pkmDetails.id.generationId = :genNb
              AND localPkm.id.langId IN :langIso
              AND pkmGenLocal.id.langId IN :langIso
              AND localPkmType.id.langId IN :langIso
              AND localPkmType.id.typeId IN pkmType
             """;


    public static final String GET_PKM_DETAILS = "" +
            "SELECT DISTINCT pkmDetails" +
            " FROM PkmDetails pkmDetails" +
            " LEFT JOIN FETCH pkmDetails.pokemon pkm" +
            " LEFT JOIN FETCH pkm.localizedPkms localPkm" +
            " LEFT JOIN FETCH pkmDetails.pkmTypes pkmTypes" +
            " LEFT JOIN FETCH pkmTypes.localizedPkmTypes localPkmType" +
            " WHERE pkmDetails.id.generationId = :" + QueryParam.GEN_NUM +
            " AND pkmDetails.id.pkmId = :" + QueryParam.PKM_ID +
            " AND localPkm.id.langId IN  :" + QueryParam.LANG_ISO +
            " AND localPkmType.id.langId IN :" + QueryParam.LANG_ISO +
            " AND localPkmType.id.typeId IN pkmTypes";


    private LocalizedPkmJPQL() {
    }


}
