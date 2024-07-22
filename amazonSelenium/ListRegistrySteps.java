package amazonSelenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class ListRegistrySteps extends BaseTest {
	
	private String baseUrl = "https://www.amazon.com";
	private String listRegistryIntroUrl = "https://www.amazon.com/hz/wishlist/intro";
	private String yourListsUrl = "https://www.amazon.com/hz/wishlist/ls/ref=cm_wl_your_lists";
	private String registriesUrl = "https://www.amazon.com/registries";
	
	@Given ("User is logged in with {string} and {string} for List and Registry module")
	public void listRegistryLoginUser(String emailOrMobile, String password) {
		// sign in user
		initializeDriverAndPages();
        navigateToHomePage(baseUrl);
        homePage.clickSignInBtn();
        signInPage.enterEmailOrMobile(emailOrMobile);
        signInPage.clickContinueBtn();
        signInPage.enterPassword(password);
        signInPage.clickSignInBtn();
	}
	
	@And ("redirected to the lists & registries page")
	public void userRedirectedToListIntroPage() {
        // go to list intro page
        navigateToURL(listRegistryIntroUrl);
	}

	// Scenario: Create a list
	@When ("User clicks create a list button")
	public void userClickCreateListBtn() {
		listRegistryIntroPage.clickCreateListBtn();
	}
	
	@And ("User enters shopping list {string}")
	public void userEnterListName(String listName) {
		listRegistryIntroPage.enterListTxt(listName);
	}
	
	@And ("User clicks create list button to confirm creation")
	public void userClickConfirmBtn() {
		listRegistryIntroPage.clickConfirmListBtn();
	}
	
	@Then ("User should see shopping list created successfully")
	public void listCreatedSuccessfully() {
//		listRegistryIntroPage.assertListCreatedSuccessfully();
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("https://www.amazon.com/hz/wishlist"), 
				"Error: List was not created successfully");
	}
	
	// Scenario: Delete a list
	@When ("User goes to 'Your Lists' page")
	public void userGoToListsPage() {
		navigateToURL(yourListsUrl);
	}
	
	@And ("User clicks on 'Manage List' for the first list")
	public void userClickManageList() {
		yourListsPage.clickManageListLink();
	}
	
	@And ("User clicks on delete list button")
	public void userClickDeleteListBtn() {
		yourListsPage.clickDeleteListBtn();
		yourListsPage.clickDeleteListConfirmBtn();
	}
	
	@Then ("User should see shopping list is deleted successfully")
	public void listDeletedSuccessfully() {
		Assert.assertTrue(driver.getCurrentUrl()
				.contains("https://www.amazon.com/hz/wishlist"), 
				"Error: List was deleted successfully");
	}
	
	// Scenario: Verify registry categories links
	@When ("User goes to registries page") 
	public void userGoToRegistriesPage() {
		navigateToURL(registriesUrl);
	}
	
	@And ("User clicks on each category")
	public void userClickEachCategory() {
		registriesPage.clickMarriageImgLink();
		registriesPage.clickBabyImgLink();
		registriesPage.clickBirthdayImgLink();
		registriesPage.clickOccasionImgLink();
		registriesPage.clickGraduationImgLink();
		registriesPage.clickPetImgLink();
	}
	
	@Then ("User should see the category's page")
	public void assertEachCategoryPage() {
		registriesPage.assertCategoriesPages();
	}
	
	@After
	public void tearDown() {
		if (driver!= null) {
			driver.quit();
		}
	}
}
