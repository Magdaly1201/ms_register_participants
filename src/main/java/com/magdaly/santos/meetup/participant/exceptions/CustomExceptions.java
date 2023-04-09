package com.magdaly.santos.meetup.participant.exceptions;

public class CustomExceptions extends Exception {

    private static final long serialVersionUID = 1L;
    protected final int code;
    protected final String userMessage;
    protected final String systemMessage;

    public CustomExceptions(int code, String userMessage, String systemMessage) {
        super();
        this.code = code;
        this.userMessage = userMessage;
        this.systemMessage = systemMessage;
    }

    public int getCode() {
        return code;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public String getSystemMessage() {
        return systemMessage;
    }

}