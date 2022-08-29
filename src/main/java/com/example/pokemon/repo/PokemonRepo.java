package com.example.pokemon.repo;

import com.example.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {

    Optional<Pokemon> findByNumber(int number);


}
