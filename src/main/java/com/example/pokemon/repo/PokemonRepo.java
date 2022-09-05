package com.example.pokemon.repo;

import com.example.pokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 29/08/2022.
 *
 * @author Laurent Lamiral
 */
@Repository
public interface PokemonRepo extends JpaRepository<Pokemon, Long> {

    Optional<Pokemon> findByNumber(int number);


}
