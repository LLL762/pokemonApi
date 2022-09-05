package com.example.pokemon.exception;

import com.example.pokemon.model.RestResponse;
import lombok.Getter;

public class RestResponseException extends RuntimeException {

    @Getter
    private final transient RestResponse response;

    public RestResponseException(RestResponse response) {
        this.response = response;
    }


}
