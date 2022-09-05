package com.example.pokemon.controller.resource;

import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.model.RestResponse;
import com.example.pokemon.model.dto.PokemonDTO;
import com.example.pokemon.model.dto.PokemonDTOMapper;
import com.example.pokemon.service.PokemonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.Map;

import static com.example.pokemon.model.RestResponseParameters.*;
import static com.example.pokemon.model.RestResponseUtility.defaultRestResponse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/pokemon")
@RequiredArgsConstructor
@Validated
public class PkmResource {

    private final PokemonDTOMapper pkmDTOMapper;
    private final PokemonService pkmService;

    private final Validator javaxValidator;


    @GetMapping("/all")
    public ResponseEntity<RestResponse> getAllPokemons(
            @RequestParam @Positive final int page,
            @RequestParam(required = false) @Positive final Integer nbPkm,
            final ServletWebRequest request
    ) {

        final int pageIndex = page - 1; // Page index starts at 0.
        final Page<Pokemon> pkmPage = pkmService.listAll(nbPkm != null ? nbPkm : 25, pageIndex);

        final Map<String, ?> data = Map.of(
                POKEMON_LIST, pkmDTOMapper.toDTO(pkmPage.getContent()),
                CURRENT_PAGE, page,
                MAX_PAGE, pkmPage.getTotalPages()
        );

        return ResponseEntity.ok(
                defaultRestResponse("pokemon", OK, request, data));
    }

    @PostMapping
    public ResponseEntity<RestResponse> savePkm(@RequestBody @Valid final PokemonDTO pkmDTO) {

        return new ResponseEntity<>(
                RestResponse.builder()
                        .date(LocalDateTime.now())
                        .data(Map.of("pokemon",
                                pkmDTOMapper.toDTO(
                                        pkmService.createPkm(
                                                pkmDTOMapper.toEntity(pkmDTO)))))
                        .message("pokemon created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build(),
                CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse> getPkmById(@PathVariable final Long id) {


        return ResponseEntity.ok(
                RestResponse.builder()
                        .date(LocalDateTime.now())
                        .data(Map.of("pokemon", pkmDTOMapper.toDTO(pkmService.findPkmById(id).orElseThrow())))
                        .message("pokemon retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build());
    }

    @DeleteMapping("/{id}")
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
