/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladDirector;
import com.JPA.MySQL.service.DirectorServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class DirectorSteps {

    @Autowired
    private DirectorServiceImpl directorService;

    int directorId;
    String directorName;
    VladDirector director;
    VladDirector tempDirector;
    List<VladDirector> directorsList;
    int correctAttribute;
    int numberOfDirectors;

    @Given("I have a director id {int}")
    public void i_have_a_director_id(Integer int1) {
        directorId = int1;
    }
    @When("i want to check director name")
    public void i_want_to_check_director_name() {
        VladDirector director = directorService.getDirector(directorId);
        directorName = director.getName();
    }
    @Then("director name is {string}")
    public void director_name_is(String string) {
        assertEquals(string, directorName);
    }

    //#########################################################

    @Given("a new director")
    public void a_new_director() {
        director = new VladDirector();
        director.setName("Carl");
        director.setSurname("Malone");
        director.setNationality("Mongolian");
        director.setDob(null);
    }
    @Given("post director into the db")
    public void post_director_into_the_db() {
        directorService.saveDirector(director);
    }
    @Given("then get the count of all directors from db")
    public void then_get_the_count_of_all_directors_from_db() {
        var directors = directorService.getAllDirectors();
        directorsList = StreamSupport.stream(directors.spliterator(), false).collect(Collectors.toList());
        directorId = directorsList.get(directorsList.size() - 1).getId();
    }
    @Given("get the last director from the db")
    public void get_the_last_director_from_the_db() {
        tempDirector = directorService.getDirector(directorId);
    }
    @When("i compare both directors")
    public void i_compare_both_directors() {
        correctAttribute = 0;
        Assertions.assertEquals(director.getName(), tempDirector.getName(), "Wrong actor name");
        correctAttribute++;
        directorId = tempDirector.getId();
        Assertions.assertEquals(director.getSurname(), tempDirector.getSurname(), "Wrong surname");
        correctAttribute++;
        Assertions.assertEquals(tempDirector.getId(), directorId, "Wrong id");
        correctAttribute++;
        Assertions.assertEquals(director.getNationality(), tempDirector.getNationality());
        correctAttribute++;
        if(tempDirector.getDob() == null)
            correctAttribute++;
    }
    @Then("directors are the same")
    public void directors_are_the_same()  {
        Assertions.assertEquals(correctAttribute, 5);
    }

    //################################################

    @Given("the total number of directors")
    public void the_total_number_of_directors()  {
        var actors = directorService.getAllDirectors();
        directorsList = StreamSupport.stream(actors.spliterator(), false).collect(Collectors.toList());
        directorId = directorsList.get(directorsList.size() - 1).getId();
        numberOfDirectors = directorsList.size();
    }
    @When("i delete the last director")
    public void i_delete_the_last_director() {
        directorService.deleteDirector(directorId);
    }
    @Then("total number of directors has to be less by one")
    public void total_number_of_directors_has_to_be_less_by_one() {
        var directors = directorService.getAllDirectors();
        --numberOfDirectors;
        Assertions.assertEquals(numberOfDirectors, StreamSupport.stream(directors.spliterator(), false).collect(Collectors.toList()).size());
    }
}
