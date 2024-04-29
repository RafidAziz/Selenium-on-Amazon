package amazonSelenium;
import java.util.*;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import io.cucumber.testng.*;
//import cucumber.api.c
//import cucumber.api.CucumberOptions;
//import cucumber.api.testng.CucumberFeatureWrapper;
//import cucumber.api.testng.TestNGCucumberRunner;

public class RunCucumberWithTestNG {

    public static void main(String[] args) {
        // Create TestNG XML suite programmatically
        XmlSuite suite = new XmlSuite();
        suite.setName("Search Suite");

        XmlTest test = new XmlTest(suite);
        test.setName("Search Test");

        // Create a TestNG XmlClass and add it to the XmlTest
        XmlClass testClass = new XmlClass(TestNGCucumberRunner.class);
        test.getClasses().add(testClass);

        // Create a Map to hold your parameters (Cucumber options)
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("plugin", "pretty");
        parameters.put("features", "/seleniumDemo/src/main/java/amazonSelenium");

        // Set the parameters to the XmlClass
        testClass.setParameters(parameters);

        // Run the TestNG suite
        TestNG testNG = new TestNG();
        testNG.setXmlSuites(Collections.singletonList(suite));
        testNG.run();
    }
}
