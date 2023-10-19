package com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.handlers;


import com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.model.ContactNotFoundException;
import com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.response.ContactErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class ContactExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ContactErrorResponse> handleException(ContactNotFoundException exc) {
        ContactErrorResponse error = new ContactErrorResponse(HttpStatus.NOT_FOUND.value(),
                exc.getStatusCode().toString(),
                exc.getReason(),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ContactErrorResponse> handleException(Exception exc) {
        ContactErrorResponse error = new ContactErrorResponse(HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                LocalDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.systemDefault()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
