package com.JPA.MySQL.cucumberTests.cucumberRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith( Cucumber.class )
@CucumberOptions(
        features = "src/test/resources/cucumberFeatures/actor.feature",
        glue = {"com.JPA.MySQL.cucumberTests.cucumberSteps"}
)

public class actorRunner {



}
