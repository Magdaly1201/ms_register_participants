package com.magdaly.santos.meetup.participant.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magdaly.santos.meetup.participant.entities.ParticipantMeetup;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SendEvent {

  private final ObjectMapper objectMapper;
  private KafkaTemplate<String, String> kafkaTemplate;

  public void addParticipantByMeetup(ParticipantMeetup participantMeetup) {
    try {
      String value = objectMapper.writeValueAsString(participantMeetup);
      sendMessage(value);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      //TODO: MEJORAR EN EXCEPTION
    }
  }

  public void sendMessage(String message) {
    String topic = "${spring.kafka.topics.meetup-participant}";
    kafkaTemplate.send(topic, message);
  }

  public void deleteParticipantByMeetup() {

  }
}
