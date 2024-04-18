package amazonSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected WebDriver driver;

    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", 
        		"/Users/rafidaziz/eclipse-workspace/chromedriver");
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
