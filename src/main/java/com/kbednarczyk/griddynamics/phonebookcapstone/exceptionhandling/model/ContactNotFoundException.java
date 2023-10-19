package com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.model;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ContactNotFoundException extends ResponseStatusException {
    public ContactNotFoundException(HttpStatusCode status) {
        super(status);
    }

    public ContactNotFoundException(HttpStatusCode status, String reason) {
        super(status, reason);
    }

    public ContactNotFoundException(int rawStatusCode, String reason, Throwable cause) {
        super(rawStatusCode, reason, cause);
    }

    public ContactNotFoundException(HttpStatusCode status, String reason, Throwable cause) {
        super(status, reason, cause);
    }

    protected ContactNotFoundException(HttpStatusCode status, String reason, Throwable cause, String messageDetailCode, Object[] messageDetailArguments) {
        super(status, reason, cause, messageDetailCode, messageDetailArguments);
    }
}
