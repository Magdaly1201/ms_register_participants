package com.magdaly.santos.meetup.participant.repositories;

import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<ParticipantMeetup, UUID> {

    List<ParticipantMeetup> findAllByUsername(String username);

    Optional<ParticipantMeetup> findByMeetIdAndUsername(int meetId, String username);

}
