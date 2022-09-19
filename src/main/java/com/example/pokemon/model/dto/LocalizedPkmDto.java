package com.example.pokemon.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public record LocalizedPkmDto(
        @Min(0)
        Long pkmId,

        String langId,

        @Positive
        int number,
        @NotBlank
        @Size(min = 1, max = 50, message = "At least {min} and less than {max}")
        String name,

        @Min(0)
        @Digits(integer = 5, fraction = 2)
        BigDecimal heightInMeter,

        @Digits(integer = 3, fraction = 3)
        @Min(0)
        BigDecimal weightInKg,

        @URL
        String imageUrl,

        String created) {
}





