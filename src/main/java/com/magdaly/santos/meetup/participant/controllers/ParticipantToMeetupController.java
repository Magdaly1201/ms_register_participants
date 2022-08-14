package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetupRequest;
import com.magdaly.santos.meetup.participant.services.ParticipantToMeetupService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/meetup/{id}/participant")
public class ParticipantToMeetupController {

    private final ParticipantToMeetupService service;

    public ParticipantToMeetupController(ParticipantToMeetupService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ParticipantToMeetupRequest participantToMeetupRequest, @NotNull @RequestParam(value = "id") int meetId) {
        return new ResponseEntity<>(this.service.create(meetId, participantToMeetupRequest), HttpStatus.OK);
    }

}
