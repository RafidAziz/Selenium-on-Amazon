package amazonSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	private By searchTextbox = By.id("twotabsearchtextbox");
	protected WebDriver driver;
	protected HomePage homePage;
	protected AmazonSearchResultsPage searchResultsPage;
	protected CreateAccountPage createAccountPage;
	protected SignInPage signInPage;
	protected CartPage cartPage;
	protected ProductDetailsPage prodDetailsPage;
	protected ListRegistryIntroPage listRegistryIntroPage;

    public void initializeDriverAndPages() {
        System.setProperty("webdriver.chrome.driver", 
        		"/Users/rafidaziz/eclipse-workspace/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new AmazonSearchResultsPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        signInPage = new SignInPage(driver);
        cartPage = new CartPage(driver);
        prodDetailsPage = new ProductDetailsPage(driver);
        listRegistryIntroPage = new ListRegistryIntroPage(driver);
//        driver.manage().window().maximize();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }
    
    public void navigateToHomePage(String url) {
    	driver.get(url);
        
    	// try catch to check if correct home page loads
        try	{
        	driver.findElement(searchTextbox);

        } catch (Exception e) {
            // If search box is not found, reload the home page
            System.out.println("Search box element not found. Reloading the home page.");
            driver.navigate().refresh();
        }
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
