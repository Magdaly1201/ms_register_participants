package com.magdaly.santos.meetup.participant.repositories;

import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantToMeetupRepository extends JpaRepository<ParticipantToMeetup, Integer> {

}
