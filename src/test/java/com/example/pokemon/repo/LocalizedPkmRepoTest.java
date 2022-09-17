package com.example.pokemon.repo;

import com.example.pokemon.entity.LocalizedPkm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LocalizedPkmRepoTest {

    @Autowired
    private LocalizedPkmRepo localizedPkmRepo;

    @Test
    void findByPkPkmIdAndPkPkmLangIdIgnoreCase() {


        final Optional<LocalizedPkm> pkm = localizedPkmRepo.getByPkFetchPkm(1L, "fR");
        assertThat(pkm).isNotEmpty();
        assertThat(pkm.get().getName()).isEqualTo("Bulbizarre");
        assertThat(pkm.get().getPokemon().getNumber()).isEqualTo(1);

    }
}