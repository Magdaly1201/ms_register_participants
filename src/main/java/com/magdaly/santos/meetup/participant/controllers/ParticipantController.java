package com.magdaly.santos.meetup.participant.controllers;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import com.magdaly.santos.meetup.participant.exceptions.AlreadySubscribedException;
import com.magdaly.santos.meetup.participant.exceptions.NotFoundMeetExceptions;
import com.magdaly.santos.meetup.participant.services.ParticipantService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/participant")
public class ParticipantController {

  private final ParticipantService service;

  public ParticipantController(ParticipantService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ParticipantMeetup create(
      @RequestParam(value = "meet_id") @NotNull int meetId,
      @RequestParam(value = "username") String username,
      @RequestParam(value = "email") @NotNull String email) throws AlreadySubscribedException {

    return this.service.create(meetId, username, email);
  }

  @DeleteMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(
          @RequestParam(value = "meet_id") @NotNull int meetId,
          //TODO:User tiene que salir del autorized
          @RequestParam(value = "username") String username
  ) throws NotFoundMeetExceptions {
    this.service.delete(meetId,username);
  }

  //TODO: paso el user luego pasar el authorized
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ParticipantMeetup> listAll(@RequestParam(value = "username") String username){
    return this.service.findAllMeetupActive(username);
  }

}
