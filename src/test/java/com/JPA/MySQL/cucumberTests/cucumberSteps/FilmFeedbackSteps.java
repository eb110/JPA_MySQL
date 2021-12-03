package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladDirectorFeedback;
import com.JPA.MySQL.model.VladFilmFeedback;
import com.JPA.MySQL.service.DirectorFeedbackServiceImpl;
import com.JPA.MySQL.service.FilmFeedbackServiceImpl;
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
public class FilmFeedbackSteps {

    @Autowired
    private FilmFeedbackServiceImpl filmFeedbackService;

    VladFilmFeedback filmFeedback;
    String feedback;
    int totalNrOfFeedbacks;
    int lastId;
    List<VladFilmFeedback> feedbackList;

    @Given("the film feedback record from the db")
    public void the_film_feedback_record_from_the_db() {
        filmFeedback = filmFeedbackService.getFilmFeedback(1);
    }
    @When("i check its film feedback")
    public void i_check_its_film_feedback() {
       feedback = filmFeedback.getFeedback();
    }
    @Then("the film feedback length is bigger then zero")
    public void the_film_feedback_length_is_bigger_then_zero() {
        Assertions.assertNotEquals(0, feedback.length(), "feedback doesn't exist");
    }

    //##################################################

    @Given("the sum of film feedbacks")
    public void the_sum_of_film_feedbacks() {
        var feedbacks = filmFeedbackService.getAllFilmFeedback();
        totalNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size();
    }
    @When("i post new film feedback")
    public void i_post_new_film_feedback() {
        filmFeedback = new VladFilmFeedback();
        filmFeedback.setFeedback("the sleepers must be awaken");
        filmFeedback.setIdFilm(1);
        filmFeedback.setIdUser(3);
        filmFeedbackService.saveFilmFeedback(filmFeedback);
    }
    @Then("new total film feedback number has to be higher by one")
    public void new_total_film_feedback_number_has_to_be_higher_by_one() {
        var feedbacks = filmFeedbackService.getAllFilmFeedback();
        var updateNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() - 1;
        Assertions.assertEquals(totalNrOfFeedbacks, updateNrOfFeedbacks, "post request error");
    }

    //####################################################

    @Given("the last id of film feedbacks")
    public void the_last_id_of_film_feedbacks() {
        var feedbacks = filmFeedbackService.getAllFilmFeedback();
        feedbackList = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList());
        lastId = feedbackList.get(feedbackList.size() - 1).getId();
    }
    @Given("the total number of film feedbacks")
    public void the_total_number_of_film_feedbacks() {
        totalNrOfFeedbacks = feedbackList.size();
    }
    @When("i delete the last film feedback record")
    public void i_delete_the_last_film_feedback_record() {
       filmFeedbackService.deleteFilmFeedback(lastId);
    }
    @Then("new total number of film feedbacks has to be lower by one")
    public void new_total_number_of_film_feedbacks_has_to_be_lower_by_one() {
        var feedbacks = filmFeedbackService.getAllFilmFeedback();
        var updateNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() + 1;
        Assertions.assertEquals(totalNrOfFeedbacks, updateNrOfFeedbacks, "delete request error");
    }
}
