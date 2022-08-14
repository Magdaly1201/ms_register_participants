package com.magdaly.santos.meetup.participant.entities;

import com.sun.istack.NotNull;

public class ParticipantToMeetupRequest {

    @NotNull
    private int meetId;

    @NotNull
    private String username;

    @NotNull
    private String email;

    public int getMeetId() {
        return meetId;
    }

    public void setMeetId(int meetId) {
        this.meetId = meetId;
    }

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
