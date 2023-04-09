package com.magdaly.santos.meetup.participant.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handlerValidation(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        if (ex.getBindingResult().hasErrors()) {
            List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(
                    err -> "El campo  : '" + err.getField() + "' " + err.getDefaultMessage()
            ).collect(Collectors.toList());
            response.put("errors", errors);
        }
        return response;
    }

    //TODO mejorar exceptions code logger
    @ExceptionHandler(NotFoundMeetExceptions.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> notFoundMeetExceptions(NotFoundMeetExceptions ex) {
        Map<String, Object> response = new HashMap<>();
        String className = ex.getStackTrace()[0].getClassName();
        int line = ex.getStackTrace()[0].getLineNumber();
        logger.error("Exception: code "+ ex.getCode() + " - " + ex.getSystemMessage() + " - Class: " + className + " - line: " + line);
        response.put("errors", ex.getCode() + " - " + ex.getUserMessage());
        return response;
    }

    @ExceptionHandler(AlreadySubscribedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> alreadySubscribedException(AlreadySubscribedException ex) {
        Map<String, Object> response = new HashMap<>();
        String className = ex.getStackTrace()[0].getClassName();
        int line = ex.getStackTrace()[0].getLineNumber();
        logger.error("Exception: code "+ ex.getCode() + " - " + ex.getSystemMessage() + " - Class: " + className + " - line: " + line);
        response.put("errors", ex.getCode() + " - " + ex.getUserMessage());
        return response;
    }

}