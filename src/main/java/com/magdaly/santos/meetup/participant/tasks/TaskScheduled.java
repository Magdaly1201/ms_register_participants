package com.magdaly.santos.meetup.participant.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskScheduled {

    @Scheduled(cron="${jobs.cronSchedule:0/15 * * * * ?}")
    public void taskExample(){
        System.out.println("Prueba scheduling");
    }
}
