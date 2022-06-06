package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.services.ParticipantService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantController {
    private ParticipantService service;
    public ParticipantController(ParticipantService service) {
        this.service = service;
    }

    public ResponseEntity<?> participantByMeet(@PathVariable(value = "id") @NotNull int meetId, @PathVariable(value="username") String username, @PathVariable(value = "email") @NotNull String email) {
        return new ResponseEntity<>(this.service.participantByMeet(meetId, username, email),HttpStatus.OK);
    }
}
