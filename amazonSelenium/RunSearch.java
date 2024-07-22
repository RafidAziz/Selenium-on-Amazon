package amazonSelenium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (	
	features = "src/main/java/amazonSelenium/search-functionality.feature",
    plugin = {"pretty", "html:target/run-search-cucumber-reports.html"}
)
public class RunSearch extends AbstractTestNGCucumberTests {

    public static void main(String[] args) {
        // Create TestNG XML suite programmatically
        XmlSuite suite = new XmlSuite();
        suite.setName("Search Suite");

        XmlTest test = new XmlTest(suite);
        test.setName("Search Test");

        // Create a TestNG XmlClass and add it to the XmlTest
        XmlClass testClass = new XmlClass(RunSearch.class);
        test.getClasses().add(testClass);

        // Run the TestNG suite
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(Collections.singletonList(suite));
        testNG.run();
    }
}
