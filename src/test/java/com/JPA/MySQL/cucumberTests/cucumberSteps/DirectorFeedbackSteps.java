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

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DirectorFeedbackSteps {

    @Autowired
    private DirectorFeedbackServiceImpl directorFeedbackService;

    VladDirectorFeedback directorFeedback;
    String feedback;
    int totalNrOfFeedbacks;
    int lastId;
    List<VladDirectorFeedback> feedbackList;

    @Given("the director feedback record from the db")
    public void the_director_feedback_record_from_the_db() {
        directorFeedback = directorFeedbackService.getDirectorFeedback(1);
    }
    @When("i check its director feedback")
    public void i_check_its_director_feedback() {
        feedback = directorFeedback.getFeedback();
    }
    @Then("the director feedback length is bigger then zero")
    public void the_director_feedback_length_is_bigger_then_zero() {
        Assertions.assertNotEquals(0, feedback.length(), "feedback doesn't exist");
    }

    //###################################################

    @Given("the sum of director feedbacks")
    public void the_sum_of_director_feedbacks() {
        var feedbacks = directorFeedbackService.getAllDirectorFeedbacks();
        totalNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size();;
    }
    @When("i post new director feedback")
    public void i_post_new_director_feedback() {
       directorFeedback = new VladDirectorFeedback();
       directorFeedback.setFeedback("the sleepers must be awaken");
       directorFeedback.setIdDirector(1);
       directorFeedback.setIdUser(3);
       directorFeedbackService.saveDirectorFeedback(directorFeedback);
    }
    @Then("new total director feedback number has to be higher by one")
    public void new_total_director_feedback_number_has_to_be_higher_by_one() {
        var feedbacks = directorFeedbackService.getAllDirectorFeedbacks();
        var updateNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() - 1;
        Assertions.assertEquals(totalNrOfFeedbacks, updateNrOfFeedbacks, "post request error");
    }

    //############################################################

    @Given("the last id of director feedbacks")
    public void the_last_id_of_director_feedbacks() {
        var feedbacks = directorFeedbackService.getAllDirectorFeedbacks();
        feedbackList = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList());
        lastId = feedbackList.get(feedbackList.size() - 1).getId();
    }

    @Given("the total number of director feedbacks")
    public void the_total_number_of_director_feedbacks() {
        totalNrOfFeedbacks = feedbackList.size();
    }
    @When("i delete the last director feedback record")
    public void i_delete_the_last_director_feedback_record() {
       directorFeedbackService.deleteDirectorFeedback(lastId);
    }
    @Then("new total number of director feedbacks has to be lower by one")
    public void new_total_number_of_director_feedbacks_has_to_be_lower_by_one() {
        var feedbacks = directorFeedbackService.getAllDirectorFeedbacks();
        var updateNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() + 1;
        Assertions.assertEquals(totalNrOfFeedbacks, updateNrOfFeedbacks, "delete request error");
    }
}
