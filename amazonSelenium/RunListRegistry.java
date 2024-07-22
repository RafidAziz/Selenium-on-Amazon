package amazonSelenium;

import java.util.Collections;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src/main/java/amazonSelenium/list-registry-functionality.feature",
    plugin = {"pretty", "html:target/run-list-registry-cucumber-reports.html"}
)
public class RunListRegistry extends AbstractTestNGCucumberTests {
    // No additional code needed here
	public static void main(String[] args) {
        // Create TestNG XML suite programmatically
        XmlSuite suite = new XmlSuite();
        suite.setName("List Registry Suite");

        XmlTest test = new XmlTest(suite);
        test.setName("List Registry Test");

        // Create a TestNG XmlClass and add it to the XmlTest
        XmlClass testClass = new XmlClass(RunListRegistry.class);
        test.getClasses().add(testClass);

        // Run the TestNG suite
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(Collections.singletonList(suite));
        testNG.run();
	}
}