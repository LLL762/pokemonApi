package com.example.pokemon.controller.resource;


import com.example.pokemon.config.PageConfig;
import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.model.dto.PokemonDTO;
import com.example.pokemon.model.dto.PokemonDTOMapper;
import com.example.pokemon.service.PokemonService;
import com.example.pokemon.utility.MockPkmData;
import com.example.pokemon.utility.easyr.MockPkmDataEasyR;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Locale;

import static com.example.pokemon.config.StaticPageConfig.NB_ITEMS_PER_PAGE_PARAM;
import static com.example.pokemon.config.StaticPageConfig.PAGE_PARAM;
import static com.example.pokemon.model.RestResponseParameters.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = PkmResource.class)
class PkmResourceGetAllTest {
    private final MockPkmData mockData = new MockPkmDataEasyR();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PageConfig pageConfig;
    @MockBean
    private PokemonService pkmService;
    @MockBean
    private PokemonDTOMapper pkmDtoMapper;
    @MockBean
    private MessageSource messageSource;


    @Test
    void ok_no_parameters() throws Exception {

        final List<PokemonDTO> mockDtos = mockData.createPkmDTOList(5);
        final String mockMessage = "Doesn't matter";
        final int mockMaxPage = 56;
        final int expectedPageIndex = 1;
        final Page<Pokemon> mockPage = mock(Page.class);

        when(pkmService.listAll(anyInt(), anyInt())).thenReturn(mockPage);
        when(pkmDtoMapper.toDTO(anyCollection())).thenReturn(mockDtos);
        when(messageSource.getMessage(anyString(), any(), any(Locale.class))).thenReturn(mockMessage);
        when(mockPage.getTotalPages()).thenReturn(mockMaxPage);

        mockMvc.perform(get("/pokemon/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(mockMessage)))
                .andExpect(jsonPath("$.data." + MAX_PAGE, is(mockMaxPage)))
                .andExpect(jsonPath("$.data." + CURRENT_PAGE, is(expectedPageIndex)))
                .andExpect(jsonPath("$.data." + POKEMON_LIST, hasSize(mockDtos.size())));
    }

    @Test
    void ok_page3_nb5() throws Exception {

        final String mockMessage = "Doesn't matter";
        final int mockMaxPage = 56;
        final int requestedPageIndex = 2;
        final int requestedNbPkm = 5;
        final List<PokemonDTO> mockDtos = mockData.createPkmDTOList(requestedNbPkm);
        final Page<Pokemon> mockPage = mock(Page.class);

        when(pkmService.listAll(requestedNbPkm, requestedPageIndex - 1)).thenReturn(mockPage);
        when(pkmDtoMapper.toDTO(anyCollection())).thenReturn(mockDtos);
        when(messageSource.getMessage(anyString(), any(), any(Locale.class))).thenReturn(mockMessage);
        when(mockPage.getTotalPages()).thenReturn(mockMaxPage);

        mockMvc.perform(get("/pokemon/all")
                        .param(PAGE_PARAM, String.valueOf(requestedPageIndex))
                        .param(NB_ITEMS_PER_PAGE_PARAM, String.valueOf(requestedNbPkm))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(mockMessage)))
                .andExpect(jsonPath("$.data." + MAX_PAGE, is(mockMaxPage)))
                .andExpect(jsonPath("$.data." + CURRENT_PAGE, is(requestedPageIndex)))
                .andExpect(jsonPath("$.data." + POKEMON_LIST, hasSize(requestedNbPkm)));
    }


    @Test
    void ok_page12_nb_superior_to_max() throws Exception {

        final String mockMessage = "Doesn't matter";
        final int mockMaxPkmPerPage = 2;
        final int mockMaxPage = 78;
        final int requestedPageIndex = 12;
        final int requestedNbPkm = 500;
        final List<PokemonDTO> mockDtos = mockData.createPkmDTOList(mockMaxPkmPerPage);
        final Page<Pokemon> mockPage = mock(Page.class);

        when(pageConfig.getMaxPageSize()).thenReturn(mockMaxPkmPerPage);
        when(pkmService.listAll(requestedNbPkm, requestedPageIndex - 1)).thenReturn(mockPage);
        when(pkmDtoMapper.toDTO(anyCollection())).thenReturn(mockDtos);
        when(messageSource.getMessage(anyString(), any(), any(Locale.class))).thenReturn(mockMessage);
        when(mockPage.getTotalPages()).thenReturn(mockMaxPage);

        mockMvc.perform(get("/pokemon/all")
                        .param(PAGE_PARAM, String.valueOf(requestedPageIndex))
                        .param(NB_ITEMS_PER_PAGE_PARAM, String.valueOf(requestedNbPkm))
                )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message", is(mockMessage)))
                .andExpect(jsonPath("$.data." + MAX_PAGE, is(mockMaxPage)))
                .andExpect(jsonPath("$.data." + CURRENT_PAGE, is(requestedPageIndex)))
                .andExpect(jsonPath("$.data." + POKEMON_LIST, hasSize(mockMaxPkmPerPage)));
    }


    @Test
    void invalid_page() throws Exception {

        final String requestedPage = "-56";

        mockMvc.perform(get("/pokemon/all")
                        .param(PAGE_PARAM, requestedPage)
                )
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").isNotEmpty())
                .andExpect(jsonPath("$.statusCode", is(400)))
                .andExpect(jsonPath("$.data").doesNotExist())
        ;
    }


}