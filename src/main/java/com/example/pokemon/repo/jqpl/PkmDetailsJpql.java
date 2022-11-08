package com.example.pokemon.repo.jqpl;

public final class PkmDetailsJpql {

    public static final String FIND_ONE_BY_ID = """                      
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

    public static final String FIND_ONE_BY_ID_ALL_LANG = """                      
               SELECT DISTINCT pkmDetails FROM PkmDetails pkmDetails
                 LEFT JOIN FETCH pkmDetails.pokemon pkm
                 LEFT JOIN FETCH pkm.localizedPkms localPkm
                 LEFT JOIN FETCH pkmDetails.generation pkmGen
                 LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal
                 LEFT JOIN FETCH pkmDetails.pkmTypes pkmType
                 LEFT JOIN FETCH pkmType.localizedPkmTypes localPkmType
                 WHERE pkmDetails.id.pkmId = :pkmId
                 AND pkmDetails.id.generationId = :genNb
                 AND localPkmType.id.typeId IN pkmType
            """;
    public static final String FIND_ONE_BY_ID_FETCH_ALL_DETAILS = """
            SELECT DISTINCT pkmDetails FROM PkmDetails pkmDetails\s
             LEFT JOIN FETCH pkmDetails.pokemon pkm\s
             LEFT JOIN FETCH pkm.localizedPkms localPkm\s
             LEFT JOIN FETCH pkmDetails.generation pkmGen\s
             LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal\s
             LEFT JOIN FETCH pkmDetails.pkmTypes pkmType\s
             LEFT JOIN FETCH pkmType.localizedPkmTypes localPkmType\s
             LEFT JOIN FETCH pkmDetails.pkmDetailsLocals pkmDetailsLocal\s
             WHERE pkmDetails.id.pkmId = :pkmId\s
             AND pkmDetails.id.generationId = :genNb\s
             AND localPkm.id.langId IN :langIso\s
             AND pkmGenLocal.id.langId IN :langIso\s
             AND localPkmType.id.langId IN :langIso\s
             AND localPkmType.id.typeId IN pkmType\s
             AND pkmDetailsLocal.id.langId IN :langIso
            """;

    public static final String FIND_ONE_BY_ID_FETCH_ALL_DETAILS_ALL_LANG = """
            SELECT DISTINCT pkmDetails FROM PkmDetails pkmDetails\s
             LEFT JOIN FETCH pkmDetails.pokemon pkm\s
             LEFT JOIN FETCH pkm.localizedPkms localPkm\s
             LEFT JOIN FETCH pkmDetails.generation pkmGen\s
             LEFT JOIN FETCH pkmGen.genLocals pkmGenLocal\s
             LEFT JOIN FETCH pkmDetails.pkmTypes pkmType\s
             LEFT JOIN FETCH pkmType.localizedPkmTypes localPkmType\s
             LEFT JOIN FETCH pkmDetails.pkmDetailsLocals pkmDetailsLocal\s
             WHERE pkmDetails.id.pkmId = :pkmId\s
             AND pkmDetails.id.generationId = :genNb\s
             AND localPkmType.id.typeId IN pkmType\s
            """;


    private PkmDetailsJpql() {
    }


}
