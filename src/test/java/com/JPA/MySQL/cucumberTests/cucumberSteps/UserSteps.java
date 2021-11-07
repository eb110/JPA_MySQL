package com.JPA.MySQL.cucumberTests.cucumberSteps;

import com.JPA.MySQL.model.VladDirector;
import com.JPA.MySQL.model.VladUser;
import com.JPA.MySQL.service.DirectorServiceImpl;
import com.JPA.MySQL.service.UserServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

public class UserSteps {

    @Autowired
    private UserServiceImpl userService;

    int userId;
    String userName;
    VladUser user;
    VladUser tempUser;
    List<VladUser> usersList;
    int correctAttribute;
    int numberOfUser;

    @Given("I have a user id {int}")
    public void i_have_a_user_id(Integer int1) {
        userId = int1;
    }
    @When("i want to check user name")
    public void i_want_to_check_user_name() {
        VladUser user = userService.getUser(userId);
        userName = user.getName();
    }
    @Then("user name is {string}")
    public void user_name_is(String string) {
        assertEquals(string, userName);
    }

    //##########################################################

    @Given("a new user")
    public void a_new_user() {
        user = new VladUser();
        user.setEmail("wfigura@op.pl");
        user.setName("Darth");
        user.setSurname("Vader");
        user.setEncryptedPassword("sixth planet of canopus");
    }
    @Given("post user into the db")
    public void post_user_into_the_db() {
        userService.saveUser(user);
    }
    @Given("then get the count of all users from db")
    public void then_get_the_count_of_all_users_from_db() {
        var users = userService.getAllUser();
        usersList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        userId = usersList.get(usersList.size() - 1).getId();
    }
    @Given("get the last user from the db")
    public void get_the_last_user_from_the_db() {
        tempUser = userService.getUser(userId);
    }
    @When("i compare both users")
    public void i_compare_both_users() {
        correctAttribute = 0;
        Assertions.assertEquals(user.getName(), tempUser.getName(), "Wrong actor name");
        correctAttribute++;
        userId = tempUser.getId();
        Assertions.assertEquals(user.getSurname(), tempUser.getSurname(), "Wrong surname");
        correctAttribute++;
        Assertions.assertEquals(tempUser.getId(), userId, "Wrong id");
        correctAttribute++;
        Assertions.assertEquals(tempUser.getEmail(), user.getEmail(), "wrong email");
        correctAttribute++;
        Assertions.assertEquals(tempUser.getEncryptedPassword(), user.getEncryptedPassword(), "wrong password");
        correctAttribute++;
    }
    @Then("users are the same")
    public void users_are_the_same() {
            Assertions.assertEquals(correctAttribute, 5);
    }

    //##########################################################

    @Given("the total number of users")
    public void the_total_number_of_users() {
        var users = userService.getAllUser();
        usersList = StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList());
        userId = usersList.get(usersList.size() - 1).getId();
        numberOfUser = usersList.size();
    }
    @When("i delete the last user")
    public void i_delete_the_last_user() {
        userService.deleteUser(userId);
    }
    @Then("total number of users has to be less by one")
    public void total_number_of_users_has_to_be_less_by_one() {
        var users = userService.getAllUser();
        --numberOfUser;
        Assertions.assertEquals(numberOfUser, StreamSupport.stream(users.spliterator(), false).collect(Collectors.toList()).size());
    }
}
