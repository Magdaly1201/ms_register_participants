package com.magdaly.santos.meetup.participant.services;

import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetup;
import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetupRequest;
import com.magdaly.santos.meetup.participant.producer.ProducerMessageToKafka;
import com.magdaly.santos.meetup.participant.repositories.ParticipantToMeetupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ParticipantToMeetupService {

    private static final Logger logger = LoggerFactory.getLogger(ParticipantToMeetupService.class);
    private final ParticipantToMeetupRepository participantToMeetupRepository;
    private final ProducerMessageToKafka producerMessageToKafka;

    public ParticipantToMeetupService(ParticipantToMeetupRepository participantToMeetupRepository, ProducerMessageToKafka producerMessageToKafka) {
        this.participantToMeetupRepository = participantToMeetupRepository;
        this.producerMessageToKafka = producerMessageToKafka;
    }

    public ParticipantToMeetup create(ParticipantToMeetupRequest participantToMeetupRequest) {
        ParticipantToMeetup participantMeetup = participantToMeetupRepository.save(new ParticipantToMeetup(participantToMeetupRequest.getUsername(), participantToMeetupRequest.getEmail(), participantToMeetupRequest.getMeetId()));
        logger.info("add participant to meetup" + participantMeetup);
        producerMessageToKafka.sendParticipantToMeetup(participantMeetup);
        return participantMeetup;
    }

    @Override
    public String toString() {
        return "ParticipantToMeetupService{" + "participantToMeetupRepository=" + participantToMeetupRepository +
                ", producerMessageToKafka=" + producerMessageToKafka + '}';
    }
}
