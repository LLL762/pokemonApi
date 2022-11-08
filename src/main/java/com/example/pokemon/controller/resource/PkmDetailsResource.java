package com.example.pokemon.controller.resource;

import com.example.pokemon.entity.PkmDetails;
import com.example.pokemon.model.AppJsonView;
import com.example.pokemon.model.RestResponse;
import com.example.pokemon.service.PkmDetailsService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.Map;

import static com.example.pokemon.config.ResourcesUri.*;
import static org.springframework.http.HttpStatus.OK;


@RestController
@RequestMapping(BASE)
@RequiredArgsConstructor
@Validated
public class PkmDetailsResource {

    private final PkmDetailsService pkmDetailsServ;


    @GetMapping(GEN + PKM)
    @JsonView(AppJsonView.projection.class)
    public ResponseEntity<RestResponse> getPkmDetails(
            final @PathVariable(name = PKM_ID_PATH_VAR) @Positive Long pkmId,
            final @PathVariable(name = GEN_NUM_PATH_VAR) @Positive Long genNum,
            final @RequestParam(name = LANG_PARAM, required = false) String[] lang,
            final @RequestHeader(value = HttpHeaders.ACCEPT_LANGUAGE, required = false) String headLang
    ) {

        System.out.println(pkmId + "--" + genNum + "--" + lang);
        final PkmDetails pkmDetails = pkmDetailsServ.getPkmDetails(pkmId, genNum, lang).orElseGet(PkmDetails::new);

        return new ResponseEntity<>(
                RestResponse.builder().data(Map.of("pkmDetails", pkmDetails)).build(),
                OK
        );
    }


}
