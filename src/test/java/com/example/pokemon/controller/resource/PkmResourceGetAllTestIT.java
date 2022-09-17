package com.example.pokemon.controller.resource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static com.example.pokemon.config.StaticPageConfig.NB_ITEMS_PER_PAGE_PARAM;
import static com.example.pokemon.config.StaticPageConfig.PAGE_PARAM;
import static com.example.pokemon.config.resource.PkmResConfig.MsgSrcConfig;
import static com.example.pokemon.model.RestResponseParameters.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
//@Sql(scripts = "sql-scripts/insert-pkm.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class PkmResourceGetAllTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MessageSource messageSource;


    @Test
    void ok_no_parameters() throws Exception {

        final int expectedNbOfPkm = 3;
        final int expectedMaxPage = 1;
        final int expectedCurrentPage = 1;
        final String expectedMessage = messageSource.getMessage(MsgSrcConfig.ALL_OK, new Object[]{expectedNbOfPkm}, Locale.ENGLISH);


        mockMvc.perform(get("/pokemon/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(expectedMessage)))
                .andExpect(jsonPath("$.data." + MAX_PAGE, is(expectedMaxPage)))
                .andExpect(jsonPath("$.data." + CURRENT_PAGE, is(expectedCurrentPage)))
                .andExpect(jsonPath("$.data." + POKEMON_LIST, hasSize(expectedNbOfPkm)));
    }


    @Test
    void ok_page1_nb2_lang_fr() throws Exception {

        final int requestedPage = 1;
        final int requestedNbOfPkm = 2;
        final String requestedLanguage = "fr";
        final int expectedMaxPage = 2;
        final String expectedMessage = messageSource.getMessage(MsgSrcConfig.ALL_OK, new Object[]{requestedNbOfPkm}, Locale.FRENCH);


        mockMvc.perform(get("/pokemon/all")
                        .param(PAGE_PARAM, String.valueOf(requestedPage))
                        .param(NB_ITEMS_PER_PAGE_PARAM, String.valueOf(requestedNbOfPkm))
                        .param("lang", requestedLanguage)
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(expectedMessage)))
                .andExpect(jsonPath("$.data." + MAX_PAGE, is(expectedMaxPage)))
                .andExpect(jsonPath("$.data." + CURRENT_PAGE, is(requestedPage)))
                .andExpect(jsonPath("$.data." + POKEMON_LIST, hasSize(requestedNbOfPkm)));
    }


}
