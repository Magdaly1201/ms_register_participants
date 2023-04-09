package com.magdaly.santos.meetup.participant.exceptions;

public class AlreadySubscribedException extends CustomExceptions {

    public AlreadySubscribedException(int code, String userMessage, String systemMessage) {
        super(code, userMessage, systemMessage);
    }
}