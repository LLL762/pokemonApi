package com.example.pokemon.controller.resource;


import com.example.pokemon.model.dto.PokemonDTOMapper;
import com.example.pokemon.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PkmResource.class)
class PkmResourceTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PokemonService pkmService;
    @MockBean
    private PokemonDTOMapper pkmDtoMapper;
    @MockBean
    private Validator javaxValidator;
    @MockBean
    private MethodValidationPostProcessor methodValidator;


    @Test
    void get_all_pkm_everything_ok() throws Exception {


//        when(pkmService.listAll(anyInt(), anyInt()))
//                .thenReturn();


        mockMvc.perform(get("/pokemon/all?page=-1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }


}