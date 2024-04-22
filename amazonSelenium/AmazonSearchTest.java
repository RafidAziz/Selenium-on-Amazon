package amazonSelenium;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonSearchTest extends BaseTest {
	
//	private WebDriver driver;
	private String baseUrl = "https://www.amazon.com";
	
	@BeforeClass
	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", 
//				"/Users/rafidaziz/eclipse-workspace/chromedriver");
//		driver = new ChromeDriver();
//        System.out.println("After creating driver object");
		
        initializeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new AmazonSearchResultsPage(driver);
		System.out.println(baseUrl);
		System.out.println(driver);

	}
	
	@Test // Test case for searching a product and displaying
		  // results of the search
	public void searchProductOnAmazonAndAssertResultsPage() {
//        System.out.println("Before going to amazon website");
	
		// Open Amazon's home page
//		driver.get("https://www.amazon.com");
//        navigateToURL(baseUrl);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
		
		// locate search textbox by id
//		WebElement searchTextbox = driver.findElement(By.id("twotabsearchtextbox"));
        // Check if the element is located correctly
//        if (searchTextbox.isDisplayed()) {
//            System.out.println("Element is located correctly.");
//        } else {
//            System.out.println("Element is not located correctly.");
//        }
		
		// clear searchTextbox
		// type 'ipad mini 6' in search box
//		searchTextbox.clear();
//		searchTextbox.click();
//		searchTextbox.sendKeys("iPad Mini 6 woohoohooo");
//		System.out.println(searchTextbox.getText());
		
		// locate search button by class name
//		WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
//		searchBtn.click();
		
		// navigate to amazon home page
        navigateToURL(baseUrl);
		System.out.println(baseUrl);
		System.out.println(driver);
		
		// search product
		homePage.searchProduct("iPad Mini 6");
		
		// assert search results page is shown
		Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(),
				"Error: Search results is not displayed");

		// locate by name
		// locate by tag name
		// locate by linked text
		// locate by partial linked text
		// locate by xpath
		// locate by css selector

	}
	
	@Test // Test case for creating a new user account
	public void createAccount() {
//		System.out.println("in create account test case");
		
		// Open Amazon's home page
        navigateToURL(baseUrl);
//		driver.get("https://www.amazon.com");
		
		// Go to login page
		WebElement accountAndLists = driver.findElement(By.id("nav-link-accountList"));
		accountAndLists.click();
		
		// Go to create account page
		WebElement createAccountBtn = driver.findElement(By.id("createAccountSubmit"));
		createAccountBtn.click();
		
		// Locate name textbox and enter name
		WebElement customerNameTxt = driver.findElement(By.name("customerName"));
		customerNameTxt.sendKeys("customer name");
		
		// Locate mobile/email textbox and enter email
		WebElement emailTxt = driver.findElement(By.cssSelector("input[class='a-input-text a-span12 a-spacing-micro auth-required-field auth-require-claim-validation']"));
		emailTxt.sendKeys("email");
		
		// Locate password textbox and enter password
		WebElement passwordTxt = driver.findElement(By.id("ap_password"));
		passwordTxt.sendKeys("password");
		
		// Locate re-enter password textbox and enter password
		WebElement passwordCheckTxt = driver.findElement(By.id("ap_password_check"));
		passwordCheckTxt.sendKeys("password");
		
		// Click continue button
		WebElement continueBtn = driver.findElement(By.id("continue"));
		continueBtn.click();
		
		// Include testng assertion code
	}
	
	@AfterClass
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
