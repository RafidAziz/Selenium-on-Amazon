package amazonSelenium;
import java.util.Collections;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class TestNGRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Create an instance of TestNG
        TestNG testNG = new TestNG();

        // Create a suite
        XmlSuite suite = new XmlSuite();
        suite.setName("Amazon Search Suite");

        // Create a test
        XmlTest test = new XmlTest(suite);
        test.setName("Amazon Search Test");

        // Add the test class to the test
        XmlClass testClass = new XmlClass(AmazonSearchTest.class);
        test.setXmlClasses(Collections.singletonList(testClass));

        // Add the suite to the TestNG instance
        testNG.setXmlSuites(Collections.singletonList(suite));

        // Run the tests
        testNG.run();
	}

}
