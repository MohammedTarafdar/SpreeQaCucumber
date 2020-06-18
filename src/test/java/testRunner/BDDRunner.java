package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "/MyDevelopment/SpreeCucumber/features",
        glue = "stepDefinations",
        dryRun = false,
        strict = true,
        monochrome = true,
        //format = {"pretty", "html:test-output"},
        tags = {}




)


public class BDDRunner {
}
