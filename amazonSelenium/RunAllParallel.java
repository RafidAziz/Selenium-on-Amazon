package amazonSelenium;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import org.testng.xml.XmlClass;
import java.util.Arrays;

public class RunAllParallel {

    public static void main(String[] args) {
        TestNG testng = new TestNG();
        
        // Create an XML Suite
        XmlSuite suite = new XmlSuite();
        suite.setName("Run All Parallel Suite");
        suite.setParallel(XmlSuite.ParallelMode.TESTS);
        suite.setThreadCount(6);

        // Create XML Tests and add TestRunner classes
        XmlTest test1 = new XmlTest(suite);
        test1.setName("RunLogin");
        test1.setXmlClasses(Arrays.asList(new XmlClass(RunLogin.class)));
        
        XmlTest test2 = new XmlTest(suite);
        test2.setName("RunSearch");
        test2.setXmlClasses(Arrays.asList(new XmlClass(RunSearch.class)));
        
        XmlTest test3 = new XmlTest(suite);
        test2.setName("RunCart");
        test2.setXmlClasses(Arrays.asList(new XmlClass(RunCart.class)));
        
        // Set the suite to TestNG
        testng.setXmlSuites(Arrays.asList(suite));
        
        // Run TestNG
        testng.run();
    }
}