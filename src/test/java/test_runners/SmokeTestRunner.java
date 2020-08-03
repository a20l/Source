package test_runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"step_defs"},
        tags = {"@Smoke"},
        plugin = {"pretty", "html:target/cucumber-report"},
        format = {"pretty", "html:target/reports"}
)

public class SmokeTestRunner {
}



