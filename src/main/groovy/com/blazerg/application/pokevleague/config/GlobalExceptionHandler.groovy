package com.blazerg.application.pokevleague.config

import groovy.util.logging.Log
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@Log
@ControllerAdvice
/**
 * this class catch the exception thrown if the bots sends a wrong or unknown command
 */
class GlobalExceptionHandler {
    @ExceptionHandler(value = [MissingMethodException.class])
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "no method found for the input command message")
    void handle(MissingMethodException e) {
        log.info("no command found for the input message")
    }
}