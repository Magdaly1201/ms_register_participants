package com.magdaly.santos.meetup.participant.repositories;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantMeetup, UUID> {

}
