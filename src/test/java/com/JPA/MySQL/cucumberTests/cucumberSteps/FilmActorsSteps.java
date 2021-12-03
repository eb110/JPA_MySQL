/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladFilmActors;
import com.JPA.MySQL.service.FilmActorsServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@SpringBootTest
public class FilmActorsSteps {

    @Autowired
    private FilmActorsServiceImpl filmActorsService;

    VladFilmActors filmActors;
    int filmId;
    int totalNrOfFilmActors;
    int lastId;
    List<VladFilmActors> filmActorsList;

    @Given("the filmActors record from the db")
    public void the_film_actors_record_from_the_db() {
        filmActors = filmActorsService.getFilmActors(1);
    }
    @When("i check its film id")
    public void i_check_its_film_id() {
        filmId = filmActors.getIdFilm();
    }
    @Then("the film id is bigger then zero")
    public void the_film_id_is_bigger_then_zero() {
        Assertions.assertNotEquals(0, filmId, "get request process failure");
    }

    //#############################################################

    @Given("the sum of filmActors")
    public void the_sum_of_film_actors() {
        var feedbacks = filmActorsService.getAllFilmActors();
        totalNrOfFilmActors = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size();
    }
    @When("i post new filmActors")
    public void i_post_new_film_actors() {
        filmActors = new VladFilmActors();
        filmActors.setIdFilm(3);
        filmActors.setIdActor(2);
        filmActorsService.saveFilmActors(filmActors);
    }
    @Then("new total filmActors number has to be higher by one")
    public void new_total_film_actors_number_has_to_be_higher_by_one() {
        var feedbacks = filmActorsService.getAllFilmActors();
        var updateNrOfFilmActors = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() - 1;
        Assertions.assertEquals(totalNrOfFilmActors, updateNrOfFilmActors, "post request error");
    }

    //#######################################################

    @Given("the last id of filmActors")
    public void the_last_id_of_film_actors() {
        var filmActors = filmActorsService.getAllFilmActors();
        filmActorsList = StreamSupport.stream(filmActors.spliterator(), false).collect(Collectors.toList());
        lastId = filmActorsList.get(filmActorsList.size() - 1).getId();
    }
    @Given("the total number of filmActors")
    public void the_total_number_of_film_actors() {
        totalNrOfFilmActors = filmActorsList.size();
    }
    @When("i delete the last filmActors record")
    public void i_delete_the_last_film_actors_record() {
        filmActorsService.deleteFilmActors(lastId);
    }
    @Then("new total number of filmActors has to be lower by one")
    public void new_total_number_of_film_actors_has_to_be_lower_by_one() {
        var feedbacks = filmActorsService.getAllFilmActors();
        var updateNrOfFilmActors = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() + 1;
        Assertions.assertEquals(totalNrOfFilmActors, updateNrOfFilmActors, "delete request error");
    }
}
