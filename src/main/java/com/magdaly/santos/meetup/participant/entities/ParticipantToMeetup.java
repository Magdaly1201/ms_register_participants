package com.magdaly.santos.meetup.participant.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "participant_meetup")
public class ParticipantToMeetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "created_at")
    private LocalDate createdAt;

    @Column(nullable = false, name = "meet_id")
    private int meetId;

    public ParticipantToMeetup() {
    }

    public ParticipantToMeetup(String username, String email, int meetId) {
        this.username = username;
        this.email = email;
        this.meetId = meetId;
        this.createdAt = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public int getMeetId() {
        return meetId;
    }

}
