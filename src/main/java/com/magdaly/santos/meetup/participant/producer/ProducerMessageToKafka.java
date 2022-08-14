package com.magdaly.santos.meetup.participant.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.magdaly.santos.meetup.participant.entities.ParticipantToMeetup;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerMessageToKafka {

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${spring.kafka.topics.meetup-participant}")
    private String TOPIC;

    public ProducerMessageToKafka(ObjectMapper objectMapper, KafkaTemplate<String, String> kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendParticipantToMeetup(ParticipantToMeetup participantMeetup) {
        try {
            this.sendMessage(objectMapper.writeValueAsString(participantMeetup));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            //TODO: MEJORAR EN EXCEPTION
        }
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }

    public void deleteParticipantByMeetup() {

    }
}
