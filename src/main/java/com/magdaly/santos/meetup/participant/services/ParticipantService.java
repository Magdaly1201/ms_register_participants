package com.magdaly.santos.meetup.participant.services;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import com.magdaly.santos.meetup.participant.repositories.ParticipantRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    private ParticipantRepository repository;

    public ParticipantService(ParticipantRepository repository) {
        this.repository = repository;
    }

    public ParticipantMeetup participantByMeet(int id, String username, String email){
        return repository.save()
    }
}
