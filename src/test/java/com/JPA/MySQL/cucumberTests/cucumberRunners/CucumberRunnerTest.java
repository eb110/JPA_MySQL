/*
Author: Wladyslaw Figura
Company: The Software Institute
Date: November 2021
git: https://github.com/eb110/JPA_MySQL.git
 */

package com.JPA.MySQL.cucumberTests.cucumberRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        features = "src/test/resources/cucumberFeatures",
        glue = {"com.JPA.MySQL.cucumberTests"}
)

public class CucumberRunnerTest {

}
