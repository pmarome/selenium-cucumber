package ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/ui/features",
        glue = "ui/stepdefinitions",
        /* Plugin for report generation */
        plugin = {"pretty", "html:target/cucumber-report.html"}
)

public class TestRunnerTest {
}
