package amazonSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected WebDriver driver;
	protected HomePage homePage;
	protected AmazonSearchResultsPage searchResultsPage;
	protected CreateAccountPage createAccountPage;
	protected SignInPage signInPage;

    public void initializeDriverAndPages() {
        System.setProperty("webdriver.chrome.driver", 
        		"/Users/rafidaziz/eclipse-workspace/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new AmazonSearchResultsPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        signInPage = new SignInPage(driver);
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
