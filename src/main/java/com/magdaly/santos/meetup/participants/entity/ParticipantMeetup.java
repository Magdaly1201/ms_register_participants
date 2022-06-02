package com.magdaly.santos.meetup.participants.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="participants_meetup")
public class ParticipantMeetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "created_at")
    private LocalDate createdAt;

    @Column(nullable = false,name="meet_id")
    private String meetId;

}
