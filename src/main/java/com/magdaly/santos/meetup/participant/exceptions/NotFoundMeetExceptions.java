package com.magdaly.santos.meetup.participant.exceptions;

public class NotFoundMeetExceptions extends CustomExceptions{

    public NotFoundMeetExceptions(int code, String userMessage, String systemMessage) {
        super(code, userMessage, systemMessage);
    }
}