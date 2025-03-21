package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "./src/test/java/feature/Register.feature",
    glue = {"stepDeff"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    tags = "@Registration"
)
public class RegisterRunBdd extends AbstractTestNGCucumberTests {
}
