package CucumberReport;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/CucumberReport" }, plugin = { "json:target/cucumber-JVM-reports/cucumber.json" })

public class runTest {
}