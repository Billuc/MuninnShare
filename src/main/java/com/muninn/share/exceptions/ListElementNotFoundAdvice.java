package com.muninn.share.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ListElementNotFoundAdvice {
    @ExceptionHandler(ListElementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String boardNotFoundHandler(ListElementNotFoundException ex) {
        return ex.getMessage();
    }
}
