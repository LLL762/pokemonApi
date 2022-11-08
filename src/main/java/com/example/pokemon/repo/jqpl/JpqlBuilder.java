package com.example.pokemon.repo.jqpl;

import java.util.StringJoiner;

import static com.example.pokemon.repo.jqpl.constant.FieldsNames.LANG_FK;
import static com.example.pokemon.repo.jqpl.constant.QueryParam.LANG_ISO;

public class JpqlBuilder {
    protected final StringJoiner select = new StringJoiner(" ");
    protected final StringJoiner where = new StringJoiner(" ");
    protected final StringJoiner fetch = new StringJoiner(" ");
    protected final StringJoiner orderBy = new StringJoiner(" ");

    public String build() {
        final StringJoiner query = new StringJoiner("");
        final String whereString = where.toString().replaceFirst("^[A-Z]+", "WHERE");
        final String queryString = query.merge(select)
                .merge(fetch)
                .add(whereString)
                .add(orderBy.length() > 0 ? "ORDER BY " : "")
                .merge(orderBy).toString();

        return queryString.trim().substring(0, queryString.length() - 1);
    }


    public JpqlBuilder select(String name, String className) {
        select.add("SELECT DISTINCT").add(name).add("FROM").add(className).add(name + "\n");
        return this;
    }

    public JpqlBuilder where(String name, String fieldName, String paramName, String operator) {
        where.add("AND").add(name + "." + fieldName).add(operator).add(":" + paramName + "\n");
        return this;
    }

    public JpqlBuilder by(String name, String fieldName, String paramName, String operator) {
        where.add("AND").add(name + fieldName).add(operator).add(":" + paramName + "\n");
        return this;
    }

    public JpqlBuilder join(String name, String fetchedField, String fetchedName) {
        fetch.add("LEFT JOIN FETCH").add(name + "." + fetchedField).add(fetchedName + "\n");
        return this;
    }

    public JpqlBuilder joinLocal(String name, String fetchedField, String fetchedName) {
        fetch.add("LEFT JOIN FETCH").add(name + "." + fetchedField).add(fetchedName + "\n");
        where(fetchedName, LANG_FK, LANG_ISO, "IN");
        return this;
    }

    public JpqlBuilder fetch(String name, String fetchedField, String fetchedName) {
        fetch.add("FETCH").add(name + "." + fetchedField).add(fetchedName + "\n");
        return this;
    }


    public JpqlBuilder orderBy(String name, String fieldName, boolean asc) {
        orderBy.add(name + "." + fieldName).add(asc ? "ASC" : "DESC").add(",");
        return this;
    }


}
