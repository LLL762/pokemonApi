package com.example.pokemon.repo;

public final class PokemonRepoJPQL {

    public static final String GET_PKM_BY_ID_FETCH_LOCALIZED = """
                        
            SELECT new com.afpa.bibliotheque.model.InfoEmprunt(exemplaire.id, livre.isbn, livre.titre,
             bibliotheque.libelle, emprunt.dateEmprunt, emprunt.dateRenduPrevu)
            FROM Exemplaire exemplaire
            JOIN exemplaire.emplacement emplacement
            JOIN emplacement.bibliotheque bibliotheque
            JOIN exemplaire.livre livre
            JOIN exemplaire.emprunt emprunt
            WHERE emprunt.id IN :ids
            """;

    private PokemonRepoJPQL() {
    }
}



