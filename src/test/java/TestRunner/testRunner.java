package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/java/Features", tags="@@Login",
                plugin = {"json:target/cucumber-reports/CucumberReport.json"},
                glue = "StepDef"
        )

public class testRunner {
}
