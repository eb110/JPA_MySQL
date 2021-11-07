package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladDirector;
import com.JPA.MySQL.model.VladFilm;
import com.JPA.MySQL.service.DirectorServiceImpl;
import com.JPA.MySQL.service.FilmServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

public class FilmSteps {

    @Autowired
    private FilmServiceImpl filmService;

    int filmId;
    String filmName;
    VladFilm film;
    VladFilm tempFilm;
    List<VladFilm> filmsList;
    int correctAttribute;
    int numberOfFilms;

    @Given("I have a film id {int}")
    public void i_have_a_film_id(Integer int1) {
        filmId = int1;
    }
    @When("i want to check film title")
    public void i_want_to_check_film_title() {
        VladFilm film = filmService.getFilm(filmId);
        filmName = film.getTitle();
    }
    @Then("film title is {string}")
    public void film_title_is(String string) {
        assertEquals(string, filmName);
    }

    //##############################################################

    @Given("a new film")
    public void a_new_film() {
        film = new VladFilm();
        film.setTitle("Star Wars");
        film.setIdDirector(1);
    }
    @Given("post film into the db")
    public void post_film_into_the_db() {
        filmService.saveFilm(film);
    }
    @Given("then get the count of all films from db")
    public void then_get_the_count_of_all_films_from_db() {
        var films = filmService.getAllFilms();
        filmsList = StreamSupport.stream(films.spliterator(), false).collect(Collectors.toList());
        filmId = filmsList.get(filmsList.size() - 1).getId();
    }
    @Given("get the last film from the db")
    public void get_the_last_film_from_the_db() {
        tempFilm = filmService.getFilm(filmId);
    }
    @When("i compare both films")
    public void i_compare_both_films() {
        correctAttribute = 0;
        Assertions.assertEquals(film.getTitle(), tempFilm.getTitle(), "Wrong title");
        correctAttribute++;
        Assertions.assertEquals(film.getIdDirector(), tempFilm.getIdDirector());
        correctAttribute++;
    }
    @Then("films are the same")
    public void films_are_the_same() {
        Assertions.assertEquals(correctAttribute, 2);
    }

    //##############################################################

    @Given("the total number of films")
    public void the_total_number_of_films() {
        var films = filmService.getAllFilms();
        filmsList = StreamSupport.stream(films.spliterator(), false).collect(Collectors.toList());
        filmId = filmsList.get(filmsList.size() - 1).getId();
        numberOfFilms = filmsList.size();
    }
    @When("i delete the last film")
    public void i_delete_the_last_film() {
        filmService.deleteFilm(filmId);
    }
    @Then("total number of films has to be less by one")
    public void total_number_of_films_has_to_be_less_by_one() {
        var films = filmService.getAllFilms();
        --numberOfFilms;
        Assertions.assertEquals(numberOfFilms, StreamSupport.stream(films.spliterator(), false).collect(Collectors.toList()).size());
    }
}
