package com.JPA.MySQL.cucumberTests.cucumberRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith( Cucumber.class )
@CucumberOptions(
        features = "src/test/resources/cucumberFeatures/actor.feature",
        glue = {"com.JPA.MySQL.cucumberTests.cucumberSteps"}
)

public class ActorRunner {

}
