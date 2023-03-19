package com.magdaly.santos.meetup.participant.integrations;

import com.magdaly.santos.meetup.participant.services.ParticipantService;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class ParticipantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParticipantService service;

    @Autowired
    private Flyway flyway;

    @BeforeEach
    public void beforeEach() {
        flyway.clean();
        flyway.migrate();
    }

    @Test
    @DisplayName("muestra las meets que esta subscrito el usuario - debe devolver dos meets")
    public void getAllMeetupSubscribedUser_when_code_200_andListTwoMeets() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/participant")
                        .param("username", "Magdy"))
                .andExpect(status().isOk());

    }
}
