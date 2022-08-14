package com.magdaly.santos.meetup.participant.entities;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;

public class ParticipantToMeetupRequest {

    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
