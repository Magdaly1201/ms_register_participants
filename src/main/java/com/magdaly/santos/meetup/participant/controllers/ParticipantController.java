package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.services.ParticipantService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/participant")
@AllArgsConstructor
@Slf4j
public class ParticipantController {

    private ParticipantService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestParam(value = "meet_id") @NotNull int meetId, @RequestParam(value = "username") String username, @RequestParam(value = "email") @NotNull String email) {
        return new ResponseEntity<>(this.service.create(meetId, username, email), HttpStatus.OK);
    }

}
