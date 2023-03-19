package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.services.ParticipantService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantController {

  private final ParticipantService service;

  public ParticipantController(ParticipantService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<?> create(
      @RequestParam(value = "meet_id") @NotNull int meetId,
      @RequestParam(value = "username") String username,
      @RequestParam(value = "email") @NotNull String email) {

    return new ResponseEntity<>(this.service.create(meetId, username, email), HttpStatus.CREATED);
  }

  @DeleteMapping
  public ResponseEntity<?> delete(
          @RequestParam(value = "meet_id") @NotNull int meetId,
          //TODO:User tiene que salir del autorized
          @RequestParam(value = "username") String username
  ){
    return new ResponseEntity<>(this.service.delete(meetId,username),HttpStatus.ACCEPTED);
  }

  //TODO: paso el user luego pasar el authorized
  @GetMapping
  public ResponseEntity<?> listAll(@RequestParam(value = "username") String username){
    return new ResponseEntity<>(this.service.findAllMeetupActive(username),HttpStatus.OK);
  }

}
