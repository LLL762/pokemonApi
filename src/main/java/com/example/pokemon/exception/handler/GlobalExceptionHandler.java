package com.example.pokemon.exception.handler;

import com.example.pokemon.model.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

import static com.example.pokemon.model.RestResponseUtility.defaultRestResponseForException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, ServletWebRequest request) {

        return new ResponseEntity<>(defaultRestResponseForException(ex, HttpStatus.NOT_FOUND, request), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleValidationExceptions(ConstraintViolationException ex, ServletWebRequest request) {

        return new ResponseEntity<>(defaultRestResponseForException(ex, HttpStatus.BAD_REQUEST, request), HttpStatus.BAD_REQUEST);
    }


    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        final RestResponse restResponse = defaultRestResponseForException(ex, status, (ServletWebRequest) request);

        log.info("Exception of type {} handled", TypeMismatchException.class);
        restResponse.setMessage("Invalid request parameter type");

        return new ResponseEntity<>(restResponse, status);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        log.info("Exception of type {} handled", ex.getClass());
        return new ResponseEntity<>(defaultRestResponseForException(ex, status, (ServletWebRequest) request), status);
    }
}
