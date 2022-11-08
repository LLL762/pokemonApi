package com.example.pokemon.controller.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.pokemon.config.ResourcesUri.BASE;
import static com.example.pokemon.config.ResourcesUri.GEN;

@RestController
@RequestMapping(BASE + GEN)
@RequiredArgsConstructor
@Validated
public class GenerationResource {


}
