package com.magdaly.santos.meetup.participant.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
//La anotación @RequiredArgsConstructor sólo incluirá argumentos para inicializar los atributos declarados como final
@Table(name="participant_meetup")
@NoArgsConstructor
public class ParticipantMeetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "created_at")
    private LocalDate createdAt;

    @Column(nullable = false,name="meet_id")
    private int meetId;

    public ParticipantMeetup(String username, String email, int meetId) {
        this.username = username;
        this.email = email;
        this.meetId = meetId;
        this.createdAt = LocalDate.now();
    }

}
