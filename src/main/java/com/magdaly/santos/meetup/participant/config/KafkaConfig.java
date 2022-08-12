package com.magdaly.santos.meetup.participant.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

  @Bean
  public NewTopic holidayEvents() {
    return TopicBuilder.name("meetups-events")
        .partitions(1)
        .replicas(1)
        .build();
  }
}
