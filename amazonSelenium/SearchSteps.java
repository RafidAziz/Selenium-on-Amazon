package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class SearchSteps extends BaseTest{

	private String baseUrl = "https://www.amazon.com";
	private String searchResultsUrl = "https://www.amazon.com/s?k=ipad+mini+6&crid=19E0CL05GIZDJ&sprefix=ipad+mini+6%2Caps%2C336&ref=nb_sb_noss_2";
	private String prodDetailsUrl = "https://www.amazon.com/Mueller-Austria-Chopper-Vegetable-Container/dp/B08N9Q24M9/ref=pd_cart_vw_crc_d_sccl_1_1/134-8582275-1630743?pd_rd_w=f1ILy&content-id=amzn1.sym.1c2f7c10-4d4d-4813-8c51-1798e23c9a80&pf_rd_p=1c2f7c10-4d4d-4813-8c51-1798e23c9a80&pf_rd_r=FG0R4R2WK063355XWJZ1&pd_rd_wg=RE3fK&pd_rd_r=0143a164-d2d8-4a85-b0ed-9924ec76da4f&pd_rd_i=B08N9Q24M9&th=1";
	
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
    
	// Scenario: Change product quantity
	@When ("User is on the product details page")
	public void userGoToProductDetailsPage() {
		navigateToURL(prodDetailsUrl);
	}
	
	@And ("User changes product quantity")
	public void userChangeProductQuantity() {
		prodDetailsPage.changeDropDownQuantityToTwo();
	}
	
	@Then ("User should see quantity is changed")
	public void userSeeQuantityChanged() {
		prodDetailsPage.assertDropDownQuantityIsTwo();
	}
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
