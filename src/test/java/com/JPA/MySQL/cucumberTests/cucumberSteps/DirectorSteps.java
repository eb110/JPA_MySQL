package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.Director;
import com.JPA.MySQL.service.DirectorServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class DirectorSteps {

    @Autowired
    private DirectorServiceImpl directorService;

    int directorId;
    String directorName;

    @Given("Director id {int}")
    public void director_id(Integer int1) {
        directorId = int1;
    }
    @When("i pick its name")
    public void i_pick_its_name() {
        Director director = new Director();
        directorName = director.getName();
    }
    @Then("Director name is  {string}")
    public void director_name_is(String string) {
        assertEquals(string, string);
    }
}
