package com.example.pokemon.repo.jqpl;

import com.example.pokemon.repo.jqpl.constant.FetchLangMod;
import com.example.pokemon.repo.jqpl.constant.QueryParam;

import static com.example.pokemon.repo.jqpl.constant.FetchLangMod.NONE;
import static com.example.pokemon.repo.jqpl.constant.FieldsNames.*;
import static com.example.pokemon.repo.jqpl.constant.Names.*;


public class PkmDetailsJpqlBuilder extends JpqlBuilder {


    public PkmDetailsJpqlBuilder selectDetails() {
        select.add("SELECT DISTINCT").add(DETAILS).add("FROM PkmDetails").add(DETAILS).add("\n");
        return this;
    }


    public PkmDetailsJpqlBuilder byId() {
        by(DETAILS, PKM_FK, QueryParam.PKM_ID, "=");
        by(DETAILS, GEN_FK, QueryParam.GEN_NUM, "=");

        return this;
    }

    public PkmDetailsJpqlBuilder fetchPkm(FetchLangMod fetchLangMod) {
        return fetch(fetchLangMod, PKM_FETCH, PKM, PKM_LOCALS_FETCH, PKM_LOCAL);
    }

    public PkmDetailsJpqlBuilder fetchGen(FetchLangMod fetchLangMod) {
        return fetch(fetchLangMod, GEN_FETCH, GEN, GEN_LOCALS_FETCH, GEN_LOCAL);
    }

    public PkmDetailsJpqlBuilder fetchLocals(FetchLangMod fetchLangMod) {

        if (fetchLangMod == NONE) {
            return this;
        }

        fetch(DETAILS_LOCALS_FETCH, DETAILS_LOCALS);

        switch (fetchLangMod) {
            case ONE -> by(DETAILS_LOCALS, LANG_FK, QueryParam.LANG_ISO, "=");
            case SOME -> by(DETAILS_LOCALS + DETAILS_LOCALS_FETCH, LANG_FK, QueryParam.LANG_ISO, "IN");
        }
        return this;
    }

    public PkmDetailsJpqlBuilder fetchTypes(FetchLangMod fetchLangMod) {
        fetch(fetchLangMod, TYPES_FETCH, TYPE, TYPE_LOCALS_FETCH, TYPE_LOCAL);

        if (fetchLangMod != NONE) {
            where.add("AND").add(TYPE_LOCAL + TYPE_FK).add("IN").add(TYPE).add("\n");
        }

        return this;
    }

    public PkmDetailsJpqlBuilder fetch(String fetched, String fetchedName) {
        fetch.add("LEFT JOIN FETCH").add(DETAILS + fetched).add(fetchedName).add("\n");
        return this;
    }

    public PkmDetailsJpqlBuilder fetch(FetchLangMod fetchLangMod, String fetched, String fetchedName, String fetchedLocal, String fetchedLocalName) {
        fetch(fetched, fetchedName);

        if (fetchLangMod == NONE) {
            return this;
        }

        fetch.add("LEFT JOIN FETCH").add(fetchedName + fetchedLocal).add(fetchedLocalName).add("\n");

        switch (fetchLangMod) {
            case ONE ->
                    where.add("AND").add(fetchedLocalName + LANG_FK).add("=").add(":" + QueryParam.LANG_ISO).add("\n");
            case SOME ->
                    where.add("AND").add(fetchedLocalName + LANG_FK).add("IN").add(":" + QueryParam.LANG_ISO).add("\n");
        }
        return this;
    }

}
