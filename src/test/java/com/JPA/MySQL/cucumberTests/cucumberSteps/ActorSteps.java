package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.Actor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActorSteps {
    Actor actor = new Actor(1, "Zenek", "Plech", "Polish", null);

    String tempName;
    String name;

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
}
