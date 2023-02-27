package com.magdaly.santos.meetup.participant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class ParticipantsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ParticipantsApplication.class, args);
  }

}
