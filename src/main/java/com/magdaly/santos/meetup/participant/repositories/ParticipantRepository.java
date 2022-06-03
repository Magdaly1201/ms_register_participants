package com.magdaly.santos.meetup.participant.repositories;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantMeetup, Integer> {

}
