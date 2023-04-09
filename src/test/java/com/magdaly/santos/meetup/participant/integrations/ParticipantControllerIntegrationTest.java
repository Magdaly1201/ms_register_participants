package com.magdaly.santos.meetup.participant.integrations;

import com.magdaly.santos.meetup.participant.services.ParticipantService;
import org.flywaydb.test.annotation.FlywayTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@FlywayTest
class ParticipantControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ParticipantService service;

    @Test
    @DisplayName("muestra las meets que esta subscrito el usuario")
    void getAllMeetupSubscribedUser_when_code_200_andListMeet() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/participant")
                        //.contentType(MediaType.APPLICATION_JSON)
                        .param("username", "Magdy"))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$[0].username").value("Magdy"))
                        //TODO:mejorar y agregar mapper y enviar como meet_id
                        .andExpect(jsonPath("$[0].meetId").value("12"))
                        .andExpect(jsonPath("$[0].email").value("magdaly.santos-test@gmail.com"));
    }

    @Test
    @DisplayName("Listar las meet por un usuario que no existe")
    void getAllMeetupSubscribedUser_when_userNotExist() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/participant")
                                //.contentType(MediaType.APPLICATION_JSON)
                                .param("username", "UserNotExist"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").doesNotExist());
    }

    @Test
    @DisplayName("crear registro de participacion del usuario para una meet")
    void createRegisterToParticipantTheUserForOneMeet() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/participant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("meet_id","5")
                        .param("username","Magdy")
                        .param("email","magdaly1201@gmail.com"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @DisplayName("crear registro de participacion del usuario para una meet que ya esta suscripto")
    void createRegisterToParticipantMeetAndTheUserIsAlreadySubscribed() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/participant")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("meet_id","12")
                                .param("username","Magdy")
                                .param("email","magdaly1201@gmail.com"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.errors").value("2 - El usuario ya esta subscrito a la meet"));
    }
}
