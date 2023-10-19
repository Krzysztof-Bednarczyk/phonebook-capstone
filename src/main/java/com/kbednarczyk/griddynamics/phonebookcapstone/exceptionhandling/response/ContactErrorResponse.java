package com.kbednarczyk.griddynamics.phonebookcapstone.exceptionhandling.response;

import java.time.LocalDateTime;

public class ContactErrorResponse {

    private int status;
    private String message;

    private String reason;
    private LocalDateTime timeStamp;

    public ContactErrorResponse() {
    }

    public ContactErrorResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public ContactErrorResponse(int status, String message, String reason, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.reason = reason;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
