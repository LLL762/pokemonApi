package com.example.pokemon.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class RestResponse {

    protected LocalDateTime date;
    protected int statusCode;
    protected HttpStatus status;
    protected HttpMethod httpMethod;
    protected String reason;
    protected String message;
    protected String devMessage;
    protected String requestedUrl;
    protected Map<String, ?> data;
    protected Map<String, String> errors;
    protected Map<String, String> warnings;
    protected Map<String, String> links;


}
