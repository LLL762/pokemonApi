package com.example.pokemon.controller.resource;

import com.example.pokemon.config.PageConfig;
import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.model.RestResponse;
import com.example.pokemon.model.dto.PokemonDTO;
import com.example.pokemon.model.dto.PokemonDTOMapper;
import com.example.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import static com.example.pokemon.config.StaticPageConfig.NB_ITEMS_PER_PAGE_PARAM;
import static com.example.pokemon.config.StaticPageConfig.PAGE_PARAM;
import static com.example.pokemon.config.resource.PkmResConfig.*;
import static com.example.pokemon.model.RestResponseParameters.*;
import static com.example.pokemon.model.RestResponseUtility.defaultRestResponse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(URL_BASE)
@RequiredArgsConstructor
@Validated
public class PkmResource {

    private final PokemonDTOMapper pkmDTOMapper;
    private final PokemonService pkmService;
    private final PageConfig pageConfig;
    private final MessageSource messageSource;


    @GetMapping(URL_ALL)
    public ResponseEntity<RestResponse> getAllPokemons(
            final @RequestParam(name = PAGE_PARAM, required = false) @Positive Integer page,
            final @RequestParam(name = NB_ITEMS_PER_PAGE_PARAM, required = false) @Positive Integer pkmPerpage,
            final ServletWebRequest request
    ) {
        String message;
        final int pageIndex = page != null ? page - 1 : 0; // Page index starts at 0.
        final Page<Pokemon> pkmPage = pkmService.listAll(pkmPerpage != null ? pkmPerpage : pageConfig.getDefaultPageSize(), pageIndex);
        final List<PokemonDTO> pkmRetrieved = pkmDTOMapper.toDTO(pkmPage.getContent());
        final Map<String, ?> data = Map.of(
                POKEMON_LIST, pkmRetrieved,
                CURRENT_PAGE, pageIndex + 1,
                MAX_PAGE, pkmPage.getTotalPages()
        );


        message = messageSource.getMessage(MsgSrcConfig.ALL_OK, new Object[]{pkmRetrieved.size()}, LocaleContextHolder.getLocale());
        return ResponseEntity.ok(defaultRestResponse(message, OK, request, data));
    }

    @PostMapping
    public ResponseEntity<RestResponse> savePkm(
            @RequestBody @Valid final PokemonDTO pkmDTO,
            final ServletWebRequest request
    ) {
        String message;

        final PokemonDTO createdPkm = pkmDTOMapper.toDTO(
                pkmService.createPkm(pkmDTOMapper.toEntity(pkmDTO)));

        final Map<String, PokemonDTO> data = Map.of(POKEMON, createdPkm);

        message = messageSource.getMessage(MsgSrcConfig.CREATED_OK, new Object[]{createdPkm.name()}, LocaleContextHolder.getLocale());

        return new ResponseEntity<>(
                defaultRestResponse(message, CREATED, request, data),
                CREATED
        );
    }

    @GetMapping(PATH_VAR_BY_ID)
    public ResponseEntity<RestResponse> getPkmById(@PathVariable final Long id, final ServletWebRequest request) {

        String message;
        final PokemonDTO pkmRetrieved = pkmDTOMapper.toDTO(pkmService.findPkmById(id).orElseThrow());

        message = messageSource.getMessage(
                MsgSrcConfig.GET_BY_ID_OK,
                new Object[]{pkmRetrieved.name(), pkmRetrieved.id()},
                LocaleContextHolder.getLocale());


        return ResponseEntity.ok(defaultRestResponse(message, OK, request, Map.of(POKEMON, pkmRetrieved)));
    }

    @PutMapping(PATH_VAR_BY_ID)
    public ResponseEntity<RestResponse> updatePkm(
            @RequestBody @Valid final PokemonDTO pkmDTO,
            final ServletWebRequest request
    ) {
        String message;

        final PokemonDTO updatedPkm = pkmDTOMapper.toDTO(
                pkmService.updatePkm(pkmDTOMapper.toEntity(pkmDTO)));

        final Map<String, PokemonDTO> data = Map.of(POKEMON, updatedPkm);

        message = messageSource.getMessage(MsgSrcConfig.CREATED_OK, new Object[]{updatedPkm.name()}, LocaleContextHolder.getLocale());

        return new ResponseEntity<>(
                defaultRestResponse(message, OK, request, data),
                OK
        );
    }


    @DeleteMapping(PATH_VAR_BY_ID)
    public ResponseEntity<RestResponse> deletePkmById(@PathVariable final Long id) {

        return ResponseEntity.ok(
                RestResponse.builder()
                        .date(LocalDateTime.now())
                        .data(Map.of("pokemon", pkmService.deletePkmById(id)))
                        .message("pokemon deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }


}
