package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.Actor;
import com.JPA.MySQL.service.ActorServiceImpl;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.picocontainer.annotations.Inject;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorSteps {

    @Autowired
    private ActorServiceImpl actorService;

    Actor actor = new Actor(1, "Zenek", "Plech", "Polish", null);

    String tempName;
    String name;

    int actorId;

    @Given("{string} is a name")
    public void is_a_name(String name){

        tempName = name;
    }

    @When("I receive the actors name")
    public void i_receive_the_actors_name(){
        name = actor.getName();
    }

    @Then("The confirmation should be positive")
        public void the_confirmation_should_be_positive(){
            assertEquals(tempName, name, "The name is not correct");
        }

    @Given("I have a film id {int}")
    public void i_have_a_film_id(Integer int1) {
        actorId = int1;
    }

    @When("i want to check the name")
    public void i_want_to_check_the_name() {
        actor = actorService.getActor(actorId);
        name = actor.getName();
    }

    @Then("I receive a {string}")
    public void i_receive_a(String string) {
       assertEquals(string, name);
    }
}
