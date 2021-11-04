package com.JPA.MySQL.controllerTests;

import com.JPA.MySQL.controller.ActorController;
import com.JPA.MySQL.model.Actor;
import com.JPA.MySQL.service.ActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ActorController.class)
public class ActorControllerTest {

    @Autowired
    private ActorController actorController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActorService actorService;

    @Test
    public void postActor() throws Exception{

        Actor actor = new Actor();
        actor.setName("zenek");
        actor.setSurname("stanik");
        actor.setNationality("polish");

            when(actorService.saveActor(any(Actor.class))).thenReturn(actor);

            mockMvc.perform(MockMvcRequestBuilders.post("/actor/add")
                    .content(new ObjectMapper().writeValueAsString(actor))
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("stanik"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.nationality").value("polish"))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("zenek"));
        }

    @Test
    public void getActorById() throws Exception {

        Actor actor = new Actor();
        actor.setName("Zenon");
        actor.setSurname("Plech");
        actor.setNationality("Polish");

        when(actorService.getActor(anyInt())).thenReturn(actor);

        mockMvc.perform(MockMvcRequestBuilders.get("/actor/getById/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Zenon"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Plech"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nationality").value("Polish"))
                .andExpect(status().isOk());
    }

    @Test
    public void actorDeleteById() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .delete("/actor/deleteById/{id}", "11")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void getAllActors() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                        .get("/actor/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

}
