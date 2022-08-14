package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetupRequest;
import com.magdaly.santos.meetup.participant.services.ParticipantToMeetupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantToMeetupController {

    private final ParticipantToMeetupService service;

    public ParticipantToMeetupController(ParticipantToMeetupService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody ParticipantToMeetupRequest participantToMeetupRequest) {
        return new ResponseEntity<>(this.service.create(participantToMeetupRequest), HttpStatus.OK);
    }

}
