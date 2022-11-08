package com.example.pokemon.repo;

import com.example.pokemon.entity.LocalizedPkmDetails;
import com.example.pokemon.entity.LocalizedPkmDetailsPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalizedPkmDetailsRepo extends JpaRepository<LocalizedPkmDetails,
        LocalizedPkmDetailsPk> {


}
