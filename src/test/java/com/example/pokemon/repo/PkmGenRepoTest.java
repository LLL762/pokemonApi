package com.example.pokemon.repo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@ActiveProfiles("test")
class PkmGenRepoTest {

    @Autowired
    private PkmGenRepo pkmGenRepo;


    @Nested
    @Sql({"/sql-scripts/generation/gen-clear.sql", "/sql-scripts/generation/gen-insert.sql"})
    @DisplayName("Tests for select queries")
    class select {

        @Test
        void findById() {
            System.out.println(pkmGenRepo.findById(1L).orElseThrow().getGenLocals().get("fr").getDescription());
        }

        @Test
        void testFindById() {
        }

        @Test
        void findAll() {
        }

        @Test
        void testFindAll() {
            pkmGenRepo.findAll().forEach(v -> System.out.println(v.getNumber()));
        }
    }
}