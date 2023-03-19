package com.magdaly.santos.meetup.participant.services;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import com.magdaly.santos.meetup.participant.producer.ProducerMessageToKafka;
import com.magdaly.santos.meetup.participant.repositories.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class ParticipantService {

  private static final Logger logger = LoggerFactory.getLogger(ParticipantService.class);
  private final ParticipantRepository participantRepository;
  private final ProducerMessageToKafka producerMessageToKafka;

  public ParticipantService(ParticipantRepository participantRepository, ProducerMessageToKafka producerMessageToKafka) {
    this.participantRepository = participantRepository;
    this.producerMessageToKafka = producerMessageToKafka;
  }

  public ParticipantMeetup create(int meetId, String username, String email) {
    try {
      ParticipantMeetup participantMeetup = participantRepository.save(new ParticipantMeetup(username, email, meetId));
      logger.info("add participant to meetup" + participantMeetup);
      producerMessageToKafka.sendParticipantToMeetup(participantMeetup);
      return participantMeetup;
    } catch (Exception e) {
      if (e.getCause() != null && e.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
        SQLIntegrityConstraintViolationException sql_violation_exception = (SQLIntegrityConstraintViolationException) e.getCause().getCause();
        logger.error("SQLIntegrityConstraintViolationException has accured. " + sql_violation_exception.getMessage());
        //TODO:AGREGAR EXCEPTIONS
        throw new RuntimeException("error");
      } else {
        logger.error(e.getMessage());
        throw new RuntimeException("error");
      }
    }
  }

  public ParticipantMeetup delete(int meetId, String username){
    ParticipantMeetup participantMeetup = participantRepository.findByMeetIdAndUsername(meetId,username).orElseThrow(()->new RuntimeException("Not found"));
    participantRepository.delete(participantMeetup);
    logger.info("delete participant to meetup" + participantMeetup);
    //todo enviar a kafka event
    return  participantMeetup;
  }

  public List<ParticipantMeetup> findAllMeetupActive(String username){
    return participantRepository.findAllByUsername(username);
  }

}
