package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class SearchSteps extends BaseTest{

	private String baseUrl = "https://www.amazon.com";
	private String searchResultsUrl = "https://www.amazon.com/s?k=ipad+mini+6&crid=19E0CL05GIZDJ&sprefix=ipad+mini+6%2Caps%2C336&ref=nb_sb_noss_2";
	
//	@Before
//	public void setUp() {		
//        initializeDriverAndPages();
//	}
	
	// Search Product Steps
	@Given("User is on the home page")
	public void userIsOnHomePage() {
    	initializeDriverAndPages();
		navigateToHomePage(baseUrl);
	}
	
    @When ("User searches {string}")
    public void userSearchProduct (String productName) {
    	homePage.enterSearchTextbox(productName);
    }
    
    @When ("User clicks on the search button")
    public void userClickSearchBtn() {
    	homePage.clickSearchBtn();
    }
    
    @Then ("User should be redirected to the results page")
    public void userViewProducts() {
    	Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(), 
    			"Error: Search results not displayed");
    }
    
    
    
    // View Product Steps
    @Given ("User is on the amazon search results page")
	public void userIsOnSearchResultsPage() {
		navigateToURL(searchResultsUrl);
	}
    
    @When ("User clicks on a product")
    public void userClickProduct() {
    	searchResultsPage.clickProductDesc();
    }
	
	@Then ("User should be redirected to the product details page")
	public void userViewProductDetails() {
		System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("https://www.amazon.com/2021-Apple-iPad-Mini"), 
				"User is not directed to product details page");
	}
    
    
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
