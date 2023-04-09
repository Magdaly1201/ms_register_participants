package com.magdaly.santos.meetup.participant.services;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import com.magdaly.santos.meetup.participant.exceptions.AlreadySubscribedException;
import com.magdaly.santos.meetup.participant.exceptions.NotFoundMeetExceptions;
import com.magdaly.santos.meetup.participant.producer.ProducerMessageToKafka;
import com.magdaly.santos.meetup.participant.repositories.ParticipantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ParticipantService {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());
  private final ParticipantRepository participantRepository;
  private final ProducerMessageToKafka producerMessageToKafka;

  public ParticipantService(ParticipantRepository participantRepository, ProducerMessageToKafka producerMessageToKafka) {
    this.participantRepository = participantRepository;
    this.producerMessageToKafka = producerMessageToKafka;
  }

  public ParticipantMeetup create(int meetId, String username, String email) throws AlreadySubscribedException {
    ParticipantMeetup participantMeetup;
    isUserSubscribedToMeet(username, meetId);
    participantMeetup = participantRepository.save(new ParticipantMeetup(username, email, meetId));
    logger.info("add participant to meetup" + participantMeetup);

    //producerMessageToKafka.sendParticipantToMeetup(participantMeetup);
    return participantMeetup;

  }

  public void delete(int meetId, String username) throws NotFoundMeetExceptions {
    ParticipantMeetup participantMeetup = findByMeetIdAndUsername(username,meetId);
    participantRepository.delete(participantMeetup);
    logger.info(MessageFormat.format("delete participant to meetup Result: {}.", participantMeetup));
    //todo enviar a kafka event
  }

  public List<ParticipantMeetup> findAllMeetupActive(String username){
    return participantRepository.findAllByUsername(username);
  }

  public ParticipantMeetup findByMeetIdAndUsername(String username,int meetId) throws NotFoundMeetExceptions {
   return participantRepository.findByMeetIdAndUsername(meetId, username).orElseThrow(()-> new NotFoundMeetExceptions(1,"Meet del usuario no encontrada",String.format("Meet del usuario no encontrada, no se consiguió la meet: %s para el usuario: %s en la base de datos", meetId, username)));
  }

  public void isUserSubscribedToMeet(String username, int meetId) throws AlreadySubscribedException {
      if (participantRepository.findByMeetIdAndUsername(meetId, username).isPresent()) {
        throw new AlreadySubscribedException(2,"El usuario ya esta subscrito a la meet",String.format("El usuario: %s ya está subscrito a la reunión: %s", username, meetId));
      }
  }


}
