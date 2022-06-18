package com.magdaly.santos.meetup.participant.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
@Setter
//La anotación @RequiredArgsConstructor sólo incluirá argumentos para inicializar los atributos declarados como final
@RequiredArgsConstructor
@Table(name="participants_meetup")
public class ParticipantMeetup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, name = "username")
    private final String username;

    @Column(nullable = false, name = "email")
    private final String email;

    @Column(nullable = false, name = "created_at")
    private LocalDate createdAt;

    @Column(nullable = false,name="meet_id")
    private String meetId;



}
