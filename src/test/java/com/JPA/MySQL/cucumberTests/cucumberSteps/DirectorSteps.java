package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.service.DirectorServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DirectorSteps {

    @Autowired
    private DirectorServiceImpl directorService;

    Director director = new Director("Zenek", "Plech", "Polish");

    String tempName;
    String name;

    @Given("{string} is a director name")
    public void is_a_director_name(String name){

        tempName = name;
    }

    @When("I receive the director name")
    public void i_receive_the_director_name(){

        name = director.getName();
    }

    @Then("The confirmation for director should be positive")
    public void the_confirmation_for_director_should_be_positive(){

        assertEquals(tempName, name, "The name is not correct");
    }

        /*
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
    */

}
