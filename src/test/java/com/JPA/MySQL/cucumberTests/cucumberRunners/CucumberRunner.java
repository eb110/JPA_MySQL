package com.JPA.MySQL.cucumberTests.cucumberRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        features = "src/test/resources/cucumberFeatures",
        glue = {"com.JPA.MySQL.cucumberTests.cucumberSteps"}
)

public class CucumberRunner {

}
