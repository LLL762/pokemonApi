package com.example.pokemon.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.LocalDateTime;
import java.util.Map;

public final class RestResponseUtility {

    private RestResponseUtility() {
    }

    public static RestResponse defaultRestResponseForException(final Exception exception, final HttpStatus status, final ServletWebRequest request) {

        return RestResponse.builder()
                .date(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .httpMethod(request.getHttpMethod())
                .requestedUrl(request.getRequest().getRequestURI())
                .message(exception.getLocalizedMessage())
                .build();
    }

    public static RestResponse defaultRestResponse(final String message,
                                                   final HttpStatus status,
                                                   final ServletWebRequest request,
                                                   final Map<String, ?> data) {

        return RestResponse.builder()
                .date(LocalDateTime.now())
                .status(status)
                .statusCode(status.value())
                .httpMethod(request.getHttpMethod())
                .requestedUrl(request.getRequest().getRequestURI())
                .message(message)
                .data(data)
                .build();
    }


}
