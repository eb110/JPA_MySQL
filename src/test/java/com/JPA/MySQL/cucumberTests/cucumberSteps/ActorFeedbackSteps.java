/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladActorFeedback;
import com.JPA.MySQL.service.ActorFeedbackServiceImpl;
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
public class ActorFeedbackSteps {

    @Autowired
    private ActorFeedbackServiceImpl actorFeedbackService;

    VladActorFeedback actorFeedback;
    String feedback;
    int totalNrOfFeedbacks;
    int lastId;
    List<VladActorFeedback> feedbackList;

    @Given("the actor feedback record from the db")
    public void the_actor_feedback_record_from_the_db() {

        actorFeedback = actorFeedbackService.getActorFeedback(1);
    }
    @When("i check its feedback")
    public void i_check_its_feedback() {
        feedback = actorFeedback.getFeedback();
    }
    @Then("the feedback length is bigger then zero")
    public void the_feedback_length_is_bigger_then_zero() {
        Assertions.assertNotEquals(0, feedback.length(), "feedback doesn't exist");
    }

    //###################################################################

    @Given("the total number of feedbacks")
    public void the_total_number_of_feedbacks() {
        var feedbacks = actorFeedbackService.getAllActorFeedbacks();
        totalNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size();
    }
    @When("i post new feedback")
    public void i_post_new_feedback() {
        actorFeedback = new VladActorFeedback();
        actorFeedback.setFeedback("cucumber code coverage sucks");
        actorFeedback.setIdActor(1);
        actorFeedback.setIdUser(1);
        actorFeedbackService.saveActorFeedback(actorFeedback);
    }
    @Then("new total number has to be higher by one")
    public void new_total_number_has_to_be_higher_by_one() {
        var feedbacks = actorFeedbackService.getAllActorFeedbacks();
        var updateNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() - 1;
        Assertions.assertEquals(totalNrOfFeedbacks, updateNrOfFeedbacks, "post request error");
    }

    //#######################################################################

    @Given("the last id of actor feedbacks")
    public void the_last_id_of_actor_feedbacks() {
        var feedbacks = actorFeedbackService.getAllActorFeedbacks();
        feedbackList = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList());
        lastId = feedbackList.get(feedbackList.size() - 1).getId();
    }

    @Given("the total number of actor feedbacks")
    public void the_total_number_of_actor_feedbacks() {
        totalNrOfFeedbacks = feedbackList.size();
    }

    @When("i delete the last record")
    public void i_delete_the_last_record() {
        actorFeedbackService.deleteActorFeedback(lastId);
    }

    @Then("new total number of actor feedbacks has to be lower by one")
    public void new_total_number_of_actor_feedbacks_has_to_be_lower_by_one() {
        var feedbacks = actorFeedbackService.getAllActorFeedbacks();
        var updateNrOfFeedbacks = StreamSupport.stream(feedbacks.spliterator(), false).collect(Collectors.toList()).size() + 1;
        Assertions.assertEquals(totalNrOfFeedbacks, updateNrOfFeedbacks, "delete request error");
    }
}
