package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetupRequest;
import com.magdaly.santos.meetup.participant.services.ParticipantToMeetupService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/meetup/{id}/participant")
public class ParticipantToMeetupController {

    private final ParticipantToMeetupService participantToMeetupService;

    public ParticipantToMeetupController(ParticipantToMeetupService participantToMeetupService) {
        this.participantToMeetupService = participantToMeetupService;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ParticipantToMeetupRequest participantToMeetupRequest, @NotNull @RequestParam(value = "id") int meetId) {
        return new ResponseEntity<>(participantToMeetupService.create(meetId, participantToMeetupRequest), HttpStatus.CREATED);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestParam(value = "id") int meetId, @NotNull @RequestParam String participantEmail) {
        participantToMeetupService.delete(meetId, participantEmail);
    }

}
