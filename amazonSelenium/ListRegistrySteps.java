package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ListRegistrySteps extends BaseTest {
	
	private String baseUrl = "https://www.amazon.com";
	private String listRegistryIntroUrl = "https://www.amazon.com/hz/wishlist/intro";
	
	@Given ("User is logged in with 'rafidamazontest@gmail.com' and 'rafidamazontest'"
			+ "and redirected to the lists & registries page")
	public void loginUserAndRedirectToListIntroPage(String emailOrMobile, String password) {
		// sign in user
		initializeDriverAndPages();
        navigateToHomePage(baseUrl);
        homePage.clickSignInBtn();
        signInPage.enterEmailOrMobile(emailOrMobile);
        signInPage.clickContinueBtn();
        signInPage.enterPassword(password);
        signInPage.clickSignInBtn();
        
        // go to list intro page
        navigateToURL(listRegistryIntroUrl);
	}

	// Scenario: Create a list
	@When ("User clicks create a list button")
	public void userClickCreateListBtn() {
		listRegistryIntroPage.clickCreateListBtn();
	}
	
	@And ("User enters 'shopping list'")
	public void userEnterListName(String listName) {
		listRegistryIntroPage.enterListTxt(listName);
	}
	
	@And ("User clicks create list button to confirm creation")
	public void userClickConfirmBtn() {
		listRegistryIntroPage.clickConfirmListBtn();
	}
	
	@Then ("User should see shopping list created successfully")
	public void listCreatedSuccessfully() {
		listRegistryIntroPage.assertListCreatedSuccessfully();
	}
}
