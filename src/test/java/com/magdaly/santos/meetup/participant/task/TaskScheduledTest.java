package com.magdaly.santos.meetup.participant.task;

import com.magdaly.santos.meetup.participant.config.ScheduledConfig;
import com.magdaly.santos.meetup.participant.tasks.TaskScheduled;
import org.awaitility.Duration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;

@SpringBootTest
@SpringJUnitConfig(ScheduledConfig.class)
@ActiveProfiles("test")
class TaskScheduledTest {

    @SpyBean
    private TaskScheduled taskScheduled;

    @Test
    @DisplayName("creacion de contexto por 5 segundos para probar el scheduled que se esta ejecutando cada 5 segundos en el profile test")
    void scheduledTestTask(){
        await().atMost(new Duration(5, TimeUnit.SECONDS))
                .untilAsserted(() -> verify(taskScheduled, atLeast(
                        1)).taskExample());
    }

}
