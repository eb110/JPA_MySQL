package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladActor;
import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.model.VladFilmActors;
import com.JPA.MySQL.service.ActorServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ActorSteps {

    @Autowired
    private ActorServiceImpl actorService;

    VladActor actor;
    String name;
    VladActor tempActor;
    int correctAttribute;
    List<VladActor> actorsList;
    int numberOfActors;
    int actorId;

    @Given("I have a film id {int}")
    public void i_have_a_film_id(Integer int1) {
        actorId = int1;
    }

    @When("i want to check the name")
    public void i_want_to_check_the_name() {
        VladActor actor = actorService.getActor(actorId);
        name = actor.getName();
    }

    @Then("I receive a {string}")
    public void i_receive_a(String string) {
       assertEquals(string, name);
    }

    //#########################################


    @Given("a new actor")
    public void a_new_actor() {
        actor = new VladActor();
        actor.setName("Eryk");
        actor.setSurname("Masztalerz");
        actor.setNationality("Polish");
        actor.setDob(null);
    }

    @Given("post actor into the db")
    public void post_actor_into_the_db() {
        actorService.saveActor(actor);
    }

    @Given("then get the count of all actors from db")
    public void then_get_the_count_of_all_actors_from_db() {
        var actors = actorService.getAllActors();
        actorsList = StreamSupport.stream(actors.spliterator(), false).collect(Collectors.toList());
        actorId = actorsList.get(actorsList.size() - 1).getId();
    }

    @Given("get the last actor from the db")
    public void get_the_last_actor_from_the_db() {
        tempActor = actorService.getActor(actorId);
    }

    @When("i compare both actors")
    public void i_compare_both_actors() {
        correctAttribute = 0;
        assertEquals(actor.getName(), tempActor.getName(), "Wrong actor name");
        correctAttribute++;
        actorId = tempActor.getId();
        assertEquals(actor.getSurname(), tempActor.getSurname(), "Wrong surname");
        correctAttribute++;
        assertEquals(tempActor.getId(), actorId, "Wrong id");
        correctAttribute++;
        assertEquals(actor.getNationality(), tempActor.getNationality());
        correctAttribute++;
        if(tempActor.getDob() == null)
            correctAttribute++;
    }

    @Then("they both are the same")
    public void they_both_are_the_same() {
        assertEquals(correctAttribute, 5);
    }

    //============================================================

    @Given("the total number of actors")
    public void the_total_number_of_actors() {
        var actors = actorService.getAllActors();
        actorsList = StreamSupport.stream(actors.spliterator(), false).collect(Collectors.toList());
        actorId = actorsList.get(actorsList.size() - 1).getId();
        numberOfActors = actorsList.size();
    }
    @When("i delete the last actor")
    public void i_delete_the_last_actor() {
        actorService.deleteActor(actorId);

    }
    @Then("the total number has to be less by {int}")
    public void the_total_number_has_to_be_less_by(Integer int1) {
        var actors = actorService.getAllActors();
        --numberOfActors;
        assertEquals(numberOfActors, StreamSupport.stream(actors.spliterator(), false).collect(Collectors.toList()).size());
    }

}
