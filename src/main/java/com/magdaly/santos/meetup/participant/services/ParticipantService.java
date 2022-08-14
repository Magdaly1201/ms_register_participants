package com.magdaly.santos.meetup.participant.services;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import com.magdaly.santos.meetup.participant.producer.ProducerMessageToKafka;
import com.magdaly.santos.meetup.participant.repositories.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

  private static final Logger logger = LoggerFactory.getLogger(ParticipantService.class);
  private final ParticipantRepository participantRepository;
  private final ProducerMessageToKafka producerMessageToKafka;

  public ParticipantService(ParticipantRepository participantRepository,
      ProducerMessageToKafka producerMessageToKafka) {
    this.participantRepository = participantRepository;
    this.producerMessageToKafka = producerMessageToKafka;
  }

  public ParticipantMeetup create(int meetId, String username, String email) {
    ParticipantMeetup participantMeetup = participantRepository.save(new ParticipantMeetup(username, email, meetId));
    logger.info("add participant to meetup" + participantMeetup);
    producerMessageToKafka.sendParticipantToMeetup(participantMeetup);
    return participantMeetup;
  }
}
