package com.chat.app.service;


public class APIResponse {
    private String message;
    private boolean status;

    // No-args constructor
    public APIResponse() {
    }

    // All-args constructor
    public APIResponse(String message, boolean status) {
        this.message = message;
        this.status = status;
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
