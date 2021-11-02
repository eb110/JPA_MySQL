package com.JPA.MySQL;

import com.JPA.MySQL.controller.ActorController;
import com.JPA.MySQL.model.Actor;
import com.JPA.MySQL.repository.ActorRepository;
import com.JPA.MySQL.service.ActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
    public void getActorByIdTest() throws Exception{

        String[] names = {"Zenon", "Romek", "Janek", "Stefan", "Enrike"};
        String[] surname = {"Plech", "Jankowski", "Kmiecik", "Kulczak", "Wazowsky"};
        Actor actor = new Actor();
        for(int i = 0; i < 1; i++) {
            actor = new Actor();
            actor.setName(names[i]);
            actor.setSurname(surname[i]);

            when(actorService.saveActor(any(Actor.class))).thenReturn(actor);

            mockMvc.perform(MockMvcRequestBuilders.post("/actor/add")
                    .content(new ObjectMapper().writeValueAsString(actor))
                    .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
        }
      //  when(actorService.getActor(anyInt())).thenReturn(actor.toString());
      //  mockMvc.perform(MockMvcRequestBuilders.get("/actor/getById/2")).
            //    andExpect(status().isOk());
    }
}
