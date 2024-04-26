package amazonSelenium;

import org.testng.Assert;

import io.cucumber.java.en.*;

public class SearchSteps extends BaseTest{

	private String baseUrl = "https://www.amazon.com";
	
	public SearchSteps() {
        initializeDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new AmazonSearchResultsPage(driver);
        createAccountPage = new CreateAccountPage(driver);
        signInPage = new SignInPage(driver);
	}
	
	@Given("User is on the home page")
	public void userIsOnHomePage() {
		driver.get(baseUrl);
	}
	
    @When ("User searches {string}")
    public void userSearchProduct (String productName) {
    	homePage.enterSearchTextbox(productName);
    	homePage.clickSearchBtn();
    }

    @Then ("User should be redirected to the results page")
    public void userViewProducts() {
    	Assert.assertTrue(searchResultsPage.isSearchResultsDisplayed(), 
    			"Error: Search results not displayed");
    }
}
