package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "./src/test/java/feature/Register.feature", // Adjust path if needed
    glue = {"stepDef"}, // Package containing your step definitions
    plugin = {"pretty", "html:target/cucumber-reports/junit"},
    monochrome = true
)
public class RegisterJunitRunner{
}