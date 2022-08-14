package com.magdaly.santos.meetup.participant.entities;

import com.magdaly.santos.meetup.participant.utils.StateParticipantMeetup;

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

    @Column(nullable = false, name = "state")
    private StateParticipantMeetup state;

    @Column(nullable = true, name = "delete_at")
    private LocalDate deleteAt;

    public ParticipantToMeetup() {
    }

    public ParticipantToMeetup(String username, String email, int meetId) {
        this.username = username;
        this.email = email;
        this.meetId = meetId;
        this.createdAt = LocalDate.now();
        this.state = StateParticipantMeetup.OK;
    }

    public void deleteParticipantToMeetup() {
        this.deleteAt = LocalDate.now();
        this.state = StateParticipantMeetup.DELETE;
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

    public StateParticipantMeetup getState() {
        return state;
    }

    @Override
    public String toString() {
        return "ParticipantToMeetup{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", meetId=" + meetId +
                ", state=" + state +
                ", deleteAt=" + deleteAt +
                '}';
    }
}
