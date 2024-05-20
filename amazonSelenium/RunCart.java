package amazonSelenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/main/java/amazonSelenium/cart-functionality.feature",
    plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunCart extends AbstractTestNGCucumberTests {
    // No additional code needed here
}