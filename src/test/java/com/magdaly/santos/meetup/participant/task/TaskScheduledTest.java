package com.magdaly.santos.meetup.participant.task;

import com.magdaly.santos.meetup.participant.config.ScheduledConfig;
import com.magdaly.santos.meetup.participant.tasks.TaskScheduled;
import org.awaitility.Duration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
@SpringJUnitConfig(ScheduledConfig.class)
public class TaskScheduledTest {

    @SpyBean
    private TaskScheduled taskScheduled;


    @Test
    void scheduledTestTask(){
        await().atMost(Duration.ONE_MINUTE)
                .untilAsserted(() -> verify(taskScheduled, atLeast(
                        6)).taskExample());

    }
}
