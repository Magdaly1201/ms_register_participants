package com.magdaly.santos.meetup.participant.services;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import com.magdaly.santos.meetup.participant.producer.SendEvent;
import com.magdaly.santos.meetup.participant.repositories.ParticipantRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ParticipantService {

  private ParticipantRepository repository;
  private SendEvent sendEvent;

  public ParticipantMeetup create(int meetId, String username, String email) {
    ParticipantMeetup participantMeetup = repository.save(
        new ParticipantMeetup(username, email, meetId));
    log.info("add participant to meetup" + participantMeetup);
    sendEvent.addParticipantToMeetup(participantMeetup);
    return participantMeetup;
  }
}
